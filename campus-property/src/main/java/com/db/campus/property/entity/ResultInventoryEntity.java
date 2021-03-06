package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "resultinventarisation", schema = "dbuniver")
@IdClass(ResultInventoryEntityPK.class)
public class ResultInventoryEntity {
    private String result;
    private long id;
    private InventoryEntity inventory;
    private ObjectPropertyEntity objectProperty;

    @Basic
    @Column(name = "RI_Result", nullable = false, length = 50)
    public String getResult() {
        return result;
    }

    public void setResult(String riResult) {
        this.result = riResult;
    }

    @Id
    @Column(name = "PK_Result_Inventarisation", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkResultInventarisation) {
        this.id = pkResultInventarisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultInventoryEntity that = (ResultInventoryEntity) o;
        return id == that.id &&
               Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, id);
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "PK_Inventarisation", referencedColumnName = "PK_Inventarisation", nullable
            = false)
    public InventoryEntity getInventory() {
        return inventory;
    }

    public void setInventory(InventoryEntity inventory) {
        this.inventory = inventory;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Object_property", referencedColumnName = "PK_Object_property", nullable
            = false)
    public ObjectPropertyEntity getObjectProperty() {
        return objectProperty;
    }

    public void setObjectProperty(ObjectPropertyEntity objectProperty) {
        this.objectProperty = objectProperty;
    }
}
