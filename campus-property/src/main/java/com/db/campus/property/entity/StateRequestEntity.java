package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "state_request", schema = "dbuniver", catalog = "")
public class StateRequestEntity {
    private String srName;
    private long pkStateRequest;
    private Collection<RequestEntity> requestsByPkStateRequest;

    @Basic
    @Column(name = "SR_Name", nullable = false, length = 50)
    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName;
    }

    @Id
    @Column(name = "PK_State_request", nullable = false)
    public long getPkStateRequest() {
        return pkStateRequest;
    }

    public void setPkStateRequest(long pkStateRequest) {
        this.pkStateRequest = pkStateRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateRequestEntity that = (StateRequestEntity) o;
        return pkStateRequest == that.pkStateRequest &&
               Objects.equals(srName, that.srName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(srName, pkStateRequest);
    }

    @OneToMany(mappedBy = "stateRequestByPkStateRequest")
    public Collection<RequestEntity> getRequestsByPkStateRequest() {
        return requestsByPkStateRequest;
    }

    public void setRequestsByPkStateRequest(Collection<RequestEntity> requestsByPkStateRequest) {
        this.requestsByPkStateRequest = requestsByPkStateRequest;
    }
}
