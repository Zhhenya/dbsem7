package com.db.campus.property.dto;

public class RequestRecordDto {

    private Long id;
    private String note;
    private ObjectPropertyDto objectPropertyDto;

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

    public ObjectPropertyDto getObjectPropertyDto() {
        return objectPropertyDto;
    }

    public void setObjectPropertyDto(ObjectPropertyDto objectPropertyDto) {
        this.objectPropertyDto = objectPropertyDto;
    }
}
