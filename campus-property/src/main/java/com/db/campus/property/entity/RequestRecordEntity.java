package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "request_record", schema = "dbuniver", catalog = "")
@IdClass(RequestRecordEntityPK.class)
public class RequestRecordEntity {
    private String rrNote;
    private long pkRequestRecord;
    private long pkRequest;
    private Long pkObjectProperty;
    private RequestEntity requestByPkRequest;
    private ObjectPropertyEntity objectPropertyByPkObjectProperty;

    @Basic
    @Column(name = "RR_Note", nullable = true, length = 500)
    public String getRrNote() {
        return rrNote;
    }

    public void setRrNote(String rrNote) {
        this.rrNote = rrNote;
    }

    @Id
    @Column(name = "PK_Request_record", nullable = false)
    public long getPkRequestRecord() {
        return pkRequestRecord;
    }

    public void setPkRequestRecord(long pkRequestRecord) {
        this.pkRequestRecord = pkRequestRecord;
    }

    @Id
    @Column(name = "PK_Request", nullable = false, insertable = false, updatable = false)
    public long getPkRequest() {
        return pkRequest;
    }

    public void setPkRequest(long pkRequest) {
        this.pkRequest = pkRequest;
    }

    @Basic
    @Column(name = "PK_Object_property", nullable = true, insertable = false, updatable = false)
    public Long getPkObjectProperty() {
        return pkObjectProperty;
    }

    public void setPkObjectProperty(Long pkObjectProperty) {
        this.pkObjectProperty = pkObjectProperty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestRecordEntity that = (RequestRecordEntity) o;
        return pkRequestRecord == that.pkRequestRecord &&
               pkRequest == that.pkRequest &&
               Objects.equals(rrNote, that.rrNote) &&
               Objects.equals(pkObjectProperty, that.pkObjectProperty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rrNote, pkRequestRecord, pkRequest, pkObjectProperty);
    }

    @ManyToOne
    @JoinColumn(name = "PK_Request", referencedColumnName = "PK_Request", nullable = false)
    public RequestEntity getRequestByPkRequest() {
        return requestByPkRequest;
    }

    public void setRequestByPkRequest(RequestEntity requestByPkRequest) {
        this.requestByPkRequest = requestByPkRequest;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Object_property", referencedColumnName = "PK_Object_property")
    public ObjectPropertyEntity getObjectPropertyByPkObjectProperty() {
        return objectPropertyByPkObjectProperty;
    }

    public void setObjectPropertyByPkObjectProperty(ObjectPropertyEntity objectPropertyByPkObjectProperty) {
        this.objectPropertyByPkObjectProperty = objectPropertyByPkObjectProperty;
    }
}
