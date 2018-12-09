package com.db.campus.property.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "inventarisation", schema = "dbuniver", catalog = "")
public class InventarisationEntity {
    private Date iDate;
    private long pkInventarisation;
    private Collection<ResultinventarisationEntity> resultinventarisationsByPkInventarisation;

    @Basic
    @Column(name = "I_Date", nullable = false)
    public Date getiDate() {
        return iDate;
    }

    public void setiDate(Date iDate) {
        this.iDate = iDate;
    }

    @Id
    @Column(name = "PK_Inventarisation", nullable = false)
    public long getPkInventarisation() {
        return pkInventarisation;
    }

    public void setPkInventarisation(long pkInventarisation) {
        this.pkInventarisation = pkInventarisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventarisationEntity that = (InventarisationEntity) o;
        return pkInventarisation == that.pkInventarisation &&
               Objects.equals(iDate, that.iDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iDate, pkInventarisation);
    }

    @OneToMany(mappedBy = "inventarisationByPkInventarisation")
    public Collection<ResultinventarisationEntity> getResultinventarisationsByPkInventarisation() {
        return resultinventarisationsByPkInventarisation;
    }

    public void setResultinventarisationsByPkInventarisation(Collection<ResultinventarisationEntity> resultinventarisationsByPkInventarisation) {
        this.resultinventarisationsByPkInventarisation = resultinventarisationsByPkInventarisation;
    }
}
