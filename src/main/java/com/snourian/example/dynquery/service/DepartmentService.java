package com.snourian.example.dynquery.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snourian.example.dynquery.domain.Project;
import com.snourian.example.dynquery.domain.Technology;
import com.snourian.example.dynquery.repository.DepartmentRepository;
import com.snourian.example.dynquery.repository.ProjectRepository;
import com.snourian.example.dynquery.repository.TechnologyRepository;
import com.snourian.example.dynquery.service.dto.DepartmentDto;
import com.snourian.example.dynquery.service.dto.ProjectTechnologiesDto;
import com.snourian.example.dynquery.service.dto.TechnologyDto;
import com.snourian.example.dynquery.service.mapper.DepartmentMapper;
import com.snourian.micronaut.querydsl.QueryParameters;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final TechnologyRepository technologyRepository;
    private final ProjectRepository projectRepository;
    private final ObjectMapper jsonMapper;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, TechnologyRepository technologyRepository,
                             ProjectRepository projectRepository, ObjectMapper jsonMapper, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.technologyRepository = technologyRepository;
        this.projectRepository = projectRepository;
        this.jsonMapper = jsonMapper;
        this.departmentMapper = departmentMapper;
    }

    @Transactional
    public void populate() throws IOException {
        final Map<String, Technology> technologies = jsonMapper.readValue(
                        Paths.get("data/technologies.json").toFile(), new TypeReference<List<TechnologyDto>>() {
                        }).stream()
                .map(dto -> new Technology(dto.getName(), dto.getType(), dto.getDetails()))
                .collect(Collectors.toMap(Technology::getName, technology -> technology));
        technologyRepository.saveAll(technologies.values());
        jsonMapper.readValue(
                        Paths.get("data/data.json").toFile(), new TypeReference<List<DepartmentDto>>() {
                        }).stream()
                .map(departmentMapper::toEntity)
                .forEach(departmentRepository::save);
        jsonMapper.readValue(
                Paths.get("data/projtech.json").toFile(), new TypeReference<List<ProjectTechnologiesDto>>() {
                }).forEach(dto -> {
                    final Project project = projectRepository.findByTitle(dto.getProject())
                                    .orElseThrow();
                    dto.getTechnologies()
                            .forEach(tech -> project.addTechnology(technologies.get(tech)));
                    projectRepository.save(project);
        });
    }

    @Transactional
    public Page<DepartmentDto> search(QueryParameters params, Pageable pageable) {
        return departmentRepository.findAll(params, pageable)
                .map(departmentMapper::toDto);
    }

    @Transactional
    public List<DepartmentDto> search(QueryParameters params) {
        return departmentRepository.findAll(params)
                .stream()
                .map(departmentMapper::toDto)
                .collect(Collectors.toList());
    }
}
