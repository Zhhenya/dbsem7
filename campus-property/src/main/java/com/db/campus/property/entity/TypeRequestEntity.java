package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "type_request", schema = "dbuniver", catalog = "")
public class TypeRequestEntity {
    private String trName;
    private long pkTypeRequest;
    private Collection<RequestEntity> requestsByPkTypeRequest;

    @Basic
    @Column(name = "TR_Name", nullable = false, length = 50)
    public String getTrName() {
        return trName;
    }

    public void setTrName(String trName) {
        this.trName = trName;
    }

    @Id
    @Column(name = "PK_Type_request", nullable = false)
    public long getPkTypeRequest() {
        return pkTypeRequest;
    }

    public void setPkTypeRequest(long pkTypeRequest) {
        this.pkTypeRequest = pkTypeRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeRequestEntity that = (TypeRequestEntity) o;
        return pkTypeRequest == that.pkTypeRequest &&
               Objects.equals(trName, that.trName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trName, pkTypeRequest);
    }

    @OneToMany(mappedBy = "typeRequestByPkTypeRequest")
    public Collection<RequestEntity> getRequestsByPkTypeRequest() {
        return requestsByPkTypeRequest;
    }

    public void setRequestsByPkTypeRequest(Collection<RequestEntity> requestsByPkTypeRequest) {
        this.requestsByPkTypeRequest = requestsByPkTypeRequest;
    }
}
