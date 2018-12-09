package com.db.campus.property.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cancellation_act", schema = "dbuniver", catalog = "")
public class CancellationActEntity {
    private Date caDate;
    private long pkCancellationAct;
    private long pkAccountant;
    private AccountantEntity accountantByPkAccountant;
    private Collection<CancellationRecordEntity> cancellationRecordsByPkCancellationAct;

    @Basic
    @Column(name = "CA_Date", nullable = false)
    public Date getCaDate() {
        return caDate;
    }

    public void setCaDate(Date caDate) {
        this.caDate = caDate;
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
    @Column(name = "PK_Accountant", nullable = false, insertable = false, updatable = false)
    public long getPkAccountant() {
        return pkAccountant;
    }

    public void setPkAccountant(long pkAccountant) {
        this.pkAccountant = pkAccountant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancellationActEntity that = (CancellationActEntity) o;
        return pkCancellationAct == that.pkCancellationAct &&
               pkAccountant == that.pkAccountant &&
               Objects.equals(caDate, that.caDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caDate, pkCancellationAct, pkAccountant);
    }

    @ManyToOne
    @JoinColumn(name = "PK_Accountant", referencedColumnName = "PK_Accountant", nullable = false)
    public AccountantEntity getAccountantByPkAccountant() {
        return accountantByPkAccountant;
    }

    public void setAccountantByPkAccountant(AccountantEntity accountantByPkAccountant) {
        this.accountantByPkAccountant = accountantByPkAccountant;
    }

    @OneToMany(mappedBy = "cancellationActByPkCancellationAct")
    public Collection<CancellationRecordEntity> getCancellationRecordsByPkCancellationAct() {
        return cancellationRecordsByPkCancellationAct;
    }

    public void setCancellationRecordsByPkCancellationAct(Collection<CancellationRecordEntity> cancellationRecordsByPkCancellationAct) {
        this.cancellationRecordsByPkCancellationAct = cancellationRecordsByPkCancellationAct;
    }
}
