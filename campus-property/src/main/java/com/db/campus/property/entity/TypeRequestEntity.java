package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "type_request", schema = "dbuniver", catalog = "")
public class TypeRequestEntity {
    private String name;
    private long id;
    private Collection<RequestEntity> requests;

    @Basic
    @Column(name = "TR_Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String trName) {
        this.name = trName;
    }

    @Id
    @Column(name = "PK_Type_request", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkTypeRequest) {
        this.id = pkTypeRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeRequestEntity that = (TypeRequestEntity) o;
        return id == that.id &&
               Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @OneToMany(mappedBy = "typeRequest")
    public Collection<RequestEntity> getRequests() {
        return requests;
    }

    public void setRequests(Collection<RequestEntity> requests) {
        this.requests = requests;
    }
}
