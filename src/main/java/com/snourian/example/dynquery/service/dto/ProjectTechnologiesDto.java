package com.snourian.example.dynquery.service.dto;

import java.util.List;

public class ProjectTechnologiesDto {

    private String project;
    private List<String> technologies;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }
}
