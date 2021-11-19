package com.snourian.example.dynquery.service.dto;

import com.snourian.example.dynquery.domain.Project;
import com.snourian.example.dynquery.domain.Technology;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ProjectDto {

    private Long id;

    private String title;

    private BigDecimal budget;

    private LocalDate startedDate;

    private Project.Status status;

    private Set<TechnologyDto> technologies = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public LocalDate getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(LocalDate startedDate) {
        this.startedDate = startedDate;
    }

    public Project.Status getStatus() {
        return status;
    }

    public void setStatus(Project.Status status) {
        this.status = status;
    }

    public Set<TechnologyDto> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<TechnologyDto> technologies) {
        this.technologies = technologies;
    }
}
