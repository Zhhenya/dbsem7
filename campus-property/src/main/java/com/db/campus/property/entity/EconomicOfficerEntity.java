package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "economic_officer", schema = "dbuniver", catalog = "")
public class EconomicOfficerEntity {
    private String eoName;
    private long pkEconomicOfficer;
    private Collection<ObjectPropertyEntity> objectPropertiesByPkEconomicOfficer;
    private Collection<RequestEntity> requestsByPkEconomicOfficer;

    @Basic
    @Column(name = "EO_Name", nullable = false, length = 100)
    public String getEoName() {
        return eoName;
    }

    public void setEoName(String eoName) {
        this.eoName = eoName;
    }

    @Id
    @Column(name = "PK_Economic_officer", nullable = false)
    public long getPkEconomicOfficer() {
        return pkEconomicOfficer;
    }

    public void setPkEconomicOfficer(long pkEconomicOfficer) {
        this.pkEconomicOfficer = pkEconomicOfficer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EconomicOfficerEntity that = (EconomicOfficerEntity) o;
        return pkEconomicOfficer == that.pkEconomicOfficer &&
               Objects.equals(eoName, that.eoName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eoName, pkEconomicOfficer);
    }

    @OneToMany(mappedBy = "economicOfficerByPkEconomicOfficer")
    public Collection<ObjectPropertyEntity> getObjectPropertiesByPkEconomicOfficer() {
        return objectPropertiesByPkEconomicOfficer;
    }

    public void setObjectPropertiesByPkEconomicOfficer(Collection<ObjectPropertyEntity> objectPropertiesByPkEconomicOfficer) {
        this.objectPropertiesByPkEconomicOfficer = objectPropertiesByPkEconomicOfficer;
    }

    @OneToMany(mappedBy = "economicOfficerByPkEconomicOfficer")
    public Collection<RequestEntity> getRequestsByPkEconomicOfficer() {
        return requestsByPkEconomicOfficer;
    }

    public void setRequestsByPkEconomicOfficer(Collection<RequestEntity> requestsByPkEconomicOfficer) {
        this.requestsByPkEconomicOfficer = requestsByPkEconomicOfficer;
    }
}
