package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "resultinventarisation", schema = "dbuniver", catalog = "")
@IdClass(ResultinventarisationEntityPK.class)
public class ResultinventarisationEntity {
    private String riResult;
    private long pkResultInventarisation;
    private long pkInventarisation;
    private long pkObjectProperty;
    private InventarisationEntity inventarisationByPkInventarisation;
    private ObjectPropertyEntity objectPropertyByPkObjectProperty;

    @Basic
    @Column(name = "RI_Result", nullable = false, length = 50)
    public String getRiResult() {
        return riResult;
    }

    public void setRiResult(String riResult) {
        this.riResult = riResult;
    }

    @Id
    @Column(name = "PK_ResultInventarisation", nullable = false)
    public long getPkResultInventarisation() {
        return pkResultInventarisation;
    }

    public void setPkResultInventarisation(long pkResultInventarisation) {
        this.pkResultInventarisation = pkResultInventarisation;
    }

    @Id
    @Column(name = "PK_Inventarisation", nullable = false)
    public long getPkInventarisation() {
        return pkInventarisation;
    }

    public void setPkInventarisation(long pkInventarisation) {
        this.pkInventarisation = pkInventarisation;
    }

    @Basic
    @Column(name = "PK_Object_property", nullable = false)
    public long getPkObjectProperty() {
        return pkObjectProperty;
    }

    public void setPkObjectProperty(long pkObjectProperty) {
        this.pkObjectProperty = pkObjectProperty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultinventarisationEntity that = (ResultinventarisationEntity) o;
        return pkResultInventarisation == that.pkResultInventarisation &&
               pkInventarisation == that.pkInventarisation &&
               pkObjectProperty == that.pkObjectProperty &&
               Objects.equals(riResult, that.riResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(riResult, pkResultInventarisation, pkInventarisation, pkObjectProperty);
    }

    @ManyToOne
    @JoinColumn(name = "PK_Inventarisation", referencedColumnName = "PK_Inventarisation", nullable
            = false)
    public InventarisationEntity getInventarisationByPkInventarisation() {
        return inventarisationByPkInventarisation;
    }

    public void setInventarisationByPkInventarisation(InventarisationEntity inventarisationByPkInventarisation) {
        this.inventarisationByPkInventarisation = inventarisationByPkInventarisation;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Object_property", referencedColumnName = "PK_Object_property", nullable
            = false)
    public ObjectPropertyEntity getObjectPropertyByPkObjectProperty() {
        return objectPropertyByPkObjectProperty;
    }

    public void setObjectPropertyByPkObjectProperty(ObjectPropertyEntity objectPropertyByPkObjectProperty) {
        this.objectPropertyByPkObjectProperty = objectPropertyByPkObjectProperty;
    }
}
