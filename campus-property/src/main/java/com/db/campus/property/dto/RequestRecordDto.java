package com.db.campus.property.dto;

public class RequestRecordDto {

    private Long id;
    private String note;
    private ObjectPropertyDto objectProperty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ObjectPropertyDto getObjectProperty() {
        return objectProperty;
    }

    public void setObjectProperty(ObjectPropertyDto objectProperty) {
        this.objectProperty = objectProperty;
    }
}
