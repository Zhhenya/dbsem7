package com.db.campus.property.entity;

import java.io.Serializable;
import java.util.Objects;

public class RequestRecordEntityPK implements Serializable {
    private long id;
    private long request;

    public long getId() {
        return id;
    }

    public void setId(long pkRequestRecord) {
        this.id = pkRequestRecord;
    }

    public long getRequest() {
        return request;
    }

    public void setRequest(long request) {
        this.request = request;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestRecordEntityPK that = (RequestRecordEntityPK) o;
        return id == that.id &&
               request == that.request;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, request);
    }
}
