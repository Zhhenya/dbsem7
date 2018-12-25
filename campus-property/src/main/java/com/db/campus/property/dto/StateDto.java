package com.db.campus.property.dto;

public class StateDto {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getState() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setState(String name) {
        this.name = name;
    }
}