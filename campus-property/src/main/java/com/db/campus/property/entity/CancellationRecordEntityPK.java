package com.db.campus.property.entity;

import java.io.Serializable;
import java.util.Objects;

public class CancellationRecordEntityPK implements Serializable {
    private long id;
    private long cancellationAct;

    public long getId() {
        return id;
    }

    public void setId(long pkCancellationRecord) {
        this.id = pkCancellationRecord;
    }

   public long getCancellationAct() {
        return cancellationAct;
    }

    public void setCancellationAct(long cancellationAct) {
        this.cancellationAct = cancellationAct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancellationRecordEntityPK that = (CancellationRecordEntityPK) o;
        return id == that.id &&
               cancellationAct == that.cancellationAct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cancellationAct);
    }
}
