package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "university_worker", schema = "dbuniver", catalog = "")
public class UniversityWorkerEntity {
    private String uiName;
    private long pkUniversityWorker;
    private Collection<RequestEntity> requestsByPkUniversityWorker;

    @Basic
    @Column(name = "UI_Name", nullable = false, length = 100)
    public String getUiName() {
        return uiName;
    }

    public void setUiName(String uiName) {
        this.uiName = uiName;
    }

    @Id
    @Column(name = "PK_University_worker", nullable = false)
    public long getPkUniversityWorker() {
        return pkUniversityWorker;
    }

    public void setPkUniversityWorker(long pkUniversityWorker) {
        this.pkUniversityWorker = pkUniversityWorker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityWorkerEntity that = (UniversityWorkerEntity) o;
        return pkUniversityWorker == that.pkUniversityWorker &&
               Objects.equals(uiName, that.uiName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uiName, pkUniversityWorker);
    }

    @OneToMany(mappedBy = "universityWorkerByPkUniversityWorker")
    public Collection<RequestEntity> getRequestsByPkUniversityWorker() {
        return requestsByPkUniversityWorker;
    }

    public void setRequestsByPkUniversityWorker(Collection<RequestEntity> requestsByPkUniversityWorker) {
        this.requestsByPkUniversityWorker = requestsByPkUniversityWorker;
    }
}
