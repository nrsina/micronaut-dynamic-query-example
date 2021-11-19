package com.snourian.example.dynquery.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Technology {

    @Id
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    private String details;

    @ManyToMany(mappedBy = "technologies")
    private Set<Project> projects = new HashSet<>();

    public Technology() {
    }

    public Technology(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Technology(String name, Type type, String details) {
        this.name = name;
        this.type = type;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        project.getTechnologies().add(this);
        this.projects.add(project);
    }

    public enum Type {
        Language,
        Framework,
        Library,
        Tool,
        Engine,
        Database,
        Device
    }
}
