package com.db.campus.property.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cancellation_act", schema = "dbuniver")
public class CancellationActEntity {
    private Date date;
    private long id;
    private AccountantEntity accountant;
    private Collection<CancellationRecordEntity> cancellationRecords;

    @Basic
    @Column(name = "CA_Date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date caDate) {
        this.date = caDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Cancellation_act", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkCancellationAct) {
        this.id = pkCancellationAct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancellationActEntity that = (CancellationActEntity) o;
        return id == that.id &&
               Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, id);
    }

    @ManyToOne
    @JoinColumn(name = "PK_Accountant", referencedColumnName = "PK_Accountant", nullable = false)
    public AccountantEntity getAccountant() {
        return accountant;
    }

    public void setAccountant(AccountantEntity accountant) {
        this.accountant = accountant;
    }

    @OneToMany(mappedBy = "cancellationAct")
    public Collection<CancellationRecordEntity> getCancellationRecords() {
        return cancellationRecords;
    }

    public void setCancellationRecords(Collection<CancellationRecordEntity> cancellationRecords) {
        this.cancellationRecords = cancellationRecords;
    }
}
