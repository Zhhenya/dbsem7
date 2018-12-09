package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "accountant", schema = "dbuniver", catalog = "")
public class AccountantEntity {
    private String aName;
    private long pkAccountant;
    private Collection<CancellationActEntity> cancellationActsByPkAccountant;
    private Collection<ObjectPropertyEntity> objectPropertiesByPkAccountant;
    private Collection<RequestEntity> requestsByPkAccountant;

    @Basic
    @Column(name = "A_Name", nullable = false, length = 100)
    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @Id
    @Column(name = "PK_Accountant", nullable = false)
    public long getPkAccountant() {
        return pkAccountant;
    }

    public void setPkAccountant(long pkAccountant) {
        this.pkAccountant = pkAccountant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountantEntity that = (AccountantEntity) o;
        return pkAccountant == that.pkAccountant &&
               Objects.equals(aName, that.aName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aName, pkAccountant);
    }

    @OneToMany(mappedBy = "accountantByPkAccountant")
    public Collection<CancellationActEntity> getCancellationActsByPkAccountant() {
        return cancellationActsByPkAccountant;
    }

    public void setCancellationActsByPkAccountant(Collection<CancellationActEntity> cancellationActsByPkAccountant) {
        this.cancellationActsByPkAccountant = cancellationActsByPkAccountant;
    }

    @OneToMany(mappedBy = "accountantByPkAccountant")
    public Collection<ObjectPropertyEntity> getObjectPropertiesByPkAccountant() {
        return objectPropertiesByPkAccountant;
    }

    public void setObjectPropertiesByPkAccountant(Collection<ObjectPropertyEntity> objectPropertiesByPkAccountant) {
        this.objectPropertiesByPkAccountant = objectPropertiesByPkAccountant;
    }

    @OneToMany(mappedBy = "accountantByPkAccountant")
    public Collection<RequestEntity> getRequestsByPkAccountant() {
        return requestsByPkAccountant;
    }

    public void setRequestsByPkAccountant(Collection<RequestEntity> requestsByPkAccountant) {
        this.requestsByPkAccountant = requestsByPkAccountant;
    }
}
