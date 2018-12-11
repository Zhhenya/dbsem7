package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "request_record", schema = "dbuniver")
@IdClass(RequestRecordEntityPK.class)
public class RequestRecordEntity {
    private String note;
    private long id;
    private long pkRequest;
    private RequestEntity request;
    private ObjectPropertyEntity objectProperty;

    @Basic
    @Column(name = "RR_Note", nullable = true, length = 500)
    public String getNote() {
        return note;
    }

    public void setNote(String rrNote) {
        this.note = rrNote;
    }

    @Id
    @Column(name = "PK_Request_record", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkRequestRecord) {
        this.id = pkRequestRecord;
    }

    @Id
    @Column(name = "PK_Request", nullable = false, insertable = false, updatable = false)
    public long getPkRequest() {
        return pkRequest;
    }

    public void setPkRequest(long pkRequest) {
        this.pkRequest = pkRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestRecordEntity that = (RequestRecordEntity) o;
        return id == that.id &&
               pkRequest == that.pkRequest &&
               Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, pkRequest, id);
    }

    @ManyToOne
    @JoinColumn(name = "PK_Request", referencedColumnName = "PK_Request", nullable = false)
    public RequestEntity getRequest() {
        return request;
    }

    public void setRequest(RequestEntity request) {
        this.request = request;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Object_property", referencedColumnName = "PK_Object_property")
    public ObjectPropertyEntity getObjectProperty() {
        return objectProperty;
    }

    public void setObjectProperty(ObjectPropertyEntity objectProperty) {
        this.objectProperty = objectProperty;
    }
}
