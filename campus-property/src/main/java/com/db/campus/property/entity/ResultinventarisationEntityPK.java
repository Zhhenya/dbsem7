package com.db.campus.property.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ResultinventarisationEntityPK implements Serializable {
    private long pkResultInventarisation;
    private long pkInventarisation;

    @Column(name = "PK_ResultInventarisation", nullable = false)
    @Id
    public long getId() {
        return pkResultInventarisation;
    }

    public void setId(long pkResultInventarisation) {
        this.pkResultInventarisation = pkResultInventarisation;
    }

    @Column(name = "PK_Inventarisation", nullable = false, insertable = false, updatable = false)
    @Id
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
        ResultinventarisationEntityPK that = (ResultinventarisationEntityPK) o;
        return pkResultInventarisation == that.pkResultInventarisation &&
               pkInventarisation == that.pkInventarisation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkResultInventarisation, pkInventarisation);
    }
}
