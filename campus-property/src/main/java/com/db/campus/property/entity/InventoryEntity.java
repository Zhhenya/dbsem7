package com.db.campus.property.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "inventarisation", schema = "dbuniver")
public class InventoryEntity {
    private Date date;
    private long id;
    private Collection<ResultInventoryEntity> resultInventory;

    @Basic
    @Column(name = "I_Date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date iDate) {
        this.date = iDate;
    }

    @Id
    @Column(name = "PK_Inventarisation", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkInventarisation) {
        this.id = pkInventarisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryEntity that = (InventoryEntity) o;
        return id == that.id &&
               Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, id);
    }

    @OneToMany(mappedBy = "inventory")
    public Collection<ResultInventoryEntity> getResultInventory() {
        return resultInventory;
    }

    public void setResultInventory(Collection<ResultInventoryEntity> resultInventory) {
        this.resultInventory = resultInventory;
    }
}
