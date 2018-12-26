package com.db.campus.property.entity;

import java.io.Serializable;
import java.util.Objects;

public class ResultInventoryEntityPK implements Serializable {
    private long id;
    private long inventory;

    public ResultInventoryEntityPK(long id, long inventory) {
        this.id = id;
        this.inventory = inventory;
    }

    public ResultInventoryEntityPK() {
    }

    public long getId() {
        return id;
    }

    public void setId(long pkResultInventarisation) {
        this.id = pkResultInventarisation;
    }

    public long getInventory() {
        return inventory;
    }

    public void setInventory(long inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultInventoryEntityPK that = (ResultInventoryEntityPK) o;
        return id == that.id &&
               inventory == that.inventory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventory);
    }
}
