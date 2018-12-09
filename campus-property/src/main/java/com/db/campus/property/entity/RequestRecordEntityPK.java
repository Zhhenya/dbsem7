package com.db.campus.property.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RequestRecordEntityPK implements Serializable {
    private long pkRequestRecord;
    private long pkRequest;

    @Column(name = "PK_Request_record", nullable = false)
    @Id
    public long getPkRequestRecord() {
        return pkRequestRecord;
    }

    public void setPkRequestRecord(long pkRequestRecord) {
        this.pkRequestRecord = pkRequestRecord;
    }

    @Column(name = "PK_Request", nullable = false, insertable = false, updatable = false)
    @Id
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
        RequestRecordEntityPK that = (RequestRecordEntityPK) o;
        return pkRequestRecord == that.pkRequestRecord &&
               pkRequest == that.pkRequest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkRequestRecord, pkRequest);
    }
}
