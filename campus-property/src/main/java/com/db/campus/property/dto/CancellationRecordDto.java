package com.db.campus.property.dto;

public class CancellationRecordDto {

    private Long id;
    private String reason;
    private ObjectPropertyDto object;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ObjectPropertyDto getObject() {
        return object;
    }

    public void setObject(ObjectPropertyDto object) {
        this.object = object;
    }
}
