package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cancellation_record", schema = "dbuniver")
@IdClass(CancellationRecordEntityPK.class)
public class CancellationRecordEntity {
    private String reason;
    private long id;
    private long pkCancellationAct;
    private CancellationActEntity cancellationAct;
    private ObjectPropertyEntity objectProperty;

    @Basic
    @Column(name = "CR_Reason", nullable = false, length = 200)
    public String getReason() {
        return reason;
    }

    public void setReason(String crReason) {
        this.reason = crReason;
    }

    @Id
    @Column(name = "PK_Cancellation_record", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkCancellationRecord) {
        this.id = pkCancellationRecord;
    }

    @Id
    @Column(name = "PK_Cancellation_act", nullable = false, insertable = false, updatable = false)
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
        CancellationRecordEntity that = (CancellationRecordEntity) o;
        return id == that.id &&
               pkCancellationAct == that.pkCancellationAct &&
               Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason, id, pkCancellationAct);
    }

    @ManyToOne
    @JoinColumn(name = "PK_Cancellation_act", referencedColumnName = "PK_Cancellation_act", nullable = false)
    public CancellationActEntity getCancellationAct() {
        return cancellationAct;
    }

    public void setCancellationAct(CancellationActEntity cancellationAct) {
        this.cancellationAct = cancellationAct;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Object_property", referencedColumnName = "PK_Object_property", nullable
            = false)
    public ObjectPropertyEntity getObjectProperty() {
        return objectProperty;
    }

    public void setObjectProperty(ObjectPropertyEntity objectPropertyByPkObjectProperty) {
        this.objectProperty = objectPropertyByPkObjectProperty;
    }
}
