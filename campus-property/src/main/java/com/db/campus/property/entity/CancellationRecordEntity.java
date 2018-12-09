package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cancellation_record", schema = "dbuniver", catalog = "")
@IdClass(CancellationRecordEntityPK.class)
public class CancellationRecordEntity {
    private String crReason;
    private long pkCancellationRecord;
    private long pkCancellationAct;
    private long pkObjectProperty;
    private CancellationActEntity cancellationActByPkCancellationAct;
    private ObjectPropertyEntity objectPropertyByPkObjectProperty;

    @Basic
    @Column(name = "CR_Reason", nullable = false, length = 200)
    public String getCrReason() {
        return crReason;
    }

    public void setCrReason(String crReason) {
        this.crReason = crReason;
    }

    @Id
    @Column(name = "PK_Cancellation_record", nullable = false)
    public long getPkCancellationRecord() {
        return pkCancellationRecord;
    }

    public void setPkCancellationRecord(long pkCancellationRecord) {
        this.pkCancellationRecord = pkCancellationRecord;
    }

    @Id
    @Column(name = "PK_Cancellation_act", nullable = false)
    public long getPkCancellationAct() {
        return pkCancellationAct;
    }

    public void setPkCancellationAct(long pkCancellationAct) {
        this.pkCancellationAct = pkCancellationAct;
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
        CancellationRecordEntity that = (CancellationRecordEntity) o;
        return pkCancellationRecord == that.pkCancellationRecord &&
               pkCancellationAct == that.pkCancellationAct &&
               pkObjectProperty == that.pkObjectProperty &&
               Objects.equals(crReason, that.crReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crReason, pkCancellationRecord, pkCancellationAct, pkObjectProperty);
    }

    @ManyToOne
    @JoinColumn(name = "PK_Cancellation_act", referencedColumnName = "PK_Cancellation_act",
            nullable = false)
    public CancellationActEntity getCancellationActByPkCancellationAct() {
        return cancellationActByPkCancellationAct;
    }

    public void setCancellationActByPkCancellationAct(CancellationActEntity cancellationActByPkCancellationAct) {
        this.cancellationActByPkCancellationAct = cancellationActByPkCancellationAct;
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
