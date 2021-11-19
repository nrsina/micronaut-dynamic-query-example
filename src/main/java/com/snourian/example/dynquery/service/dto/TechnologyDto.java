package com.snourian.example.dynquery.service.dto;

import com.snourian.example.dynquery.domain.Technology;

public class TechnologyDto {

    private String name;

    private Technology.Type type;

    private String details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Technology.Type getType() {
        return type;
    }

    public void setType(Technology.Type type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
