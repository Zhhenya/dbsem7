package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "university_worker", schema = "dbuniver")
public class UniversityWorkerEntity {
    private String name;
    private long id;
    private Collection<RequestEntity> requests;

    @Basic
    @Column(name = "UI_Name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String uiName) {
        this.name = uiName;
    }

    @Id
    @Column(name = "PK_University_worker", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkUniversityWorker) {
        this.id = pkUniversityWorker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityWorkerEntity that = (UniversityWorkerEntity) o;
        return id == that.id &&
               Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @OneToMany(mappedBy = "universityWorker")
    public Collection<RequestEntity> getRequests() {
        return requests;
    }

    public void setRequests(Collection<RequestEntity> requests) {
        this.requests = requests;
    }
}
