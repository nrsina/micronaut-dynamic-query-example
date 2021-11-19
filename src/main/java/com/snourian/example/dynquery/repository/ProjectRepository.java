package com.snourian.example.dynquery.repository;

import com.snourian.example.dynquery.domain.Project;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Optional<Project> findByTitle(String title);
}
