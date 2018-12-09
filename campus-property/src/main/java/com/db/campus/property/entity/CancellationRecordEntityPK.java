package com.db.campus.property.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CancellationRecordEntityPK implements Serializable {
    private long pkCancellationRecord;
    private long pkCancellationAct;

    @Column(name = "PK_Cancellation_record", nullable = false)
    @Id
    public long getPkCancellationRecord() {
        return pkCancellationRecord;
    }

    public void setPkCancellationRecord(long pkCancellationRecord) {
        this.pkCancellationRecord = pkCancellationRecord;
    }

    @Column(name = "PK_Cancellation_act", nullable = false)
    @Id
    public long getPkCancellationAct() {
        return pkCancellationAct;
    }

    public void setPkCancellationAct(long pkCancellationAct) {
        this.pkCancellationAct = pkCancellationAct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancellationRecordEntityPK that = (CancellationRecordEntityPK) o;
        return pkCancellationRecord == that.pkCancellationRecord &&
               pkCancellationAct == that.pkCancellationAct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkCancellationRecord, pkCancellationAct);
    }
}
