package com.db.campus.property.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "object_property", schema = "dbuniver")
public class ObjectPropertyEntity {
    private String caption;
    private String propertyNumber;
    private String maker;
    private Date date;
    private BigDecimal cost;
    private long id;
    private Collection<CancellationRecordEntity> cancellationRecords;
    private RoomEntity room;
    private StateEntity state;
    private EconomicOfficerEntity economicOfficer;
    private AccountantEntity accountant;
    private Collection<RequestRecordEntity> requestRecords;
    private Collection<ResultInventoryEntity> resultInventory;

    @Basic
    @Column(name = "OP_Caption", nullable = false, length = 50)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String opCaption) {
        this.caption = opCaption;
    }

    @Basic
    @Column(name = "OP_Property_number", nullable = false, length = 50)
    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String opPropertyNumber) {
        this.propertyNumber = opPropertyNumber;
    }

    @Basic
    @Column(name = "OP_Maker", nullable = false, length = 50)
    public String getMaker() {
        return maker;
    }

    public void setMaker(String opMaker) {
        this.maker = opMaker;
    }

    @Basic
    @Column(name = "OP_Date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date opDate) {
        this.date = opDate;
    }

    @Basic
    @Column(name = "OP_Cost", nullable = false, precision = 2)
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal opCost) {
        this.cost = opCost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Object_property", nullable = false, updatable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkObjectProperty) {
        this.id = pkObjectProperty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectPropertyEntity that = (ObjectPropertyEntity) o;
        return id == that.id &&
               Objects.equals(caption, that.caption) &&
               Objects.equals(propertyNumber, that.propertyNumber) &&
               Objects.equals(maker, that.maker) &&
               Objects.equals(date, that.date) &&
               Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caption, propertyNumber, maker, date, cost, id);
    }

    @OneToMany(mappedBy = "objectProperty")
    public Collection<CancellationRecordEntity> getCancellationRecords() {
        return cancellationRecords;
    }

    public void setCancellationRecords(Collection<CancellationRecordEntity> cancellationRecords) {
        this.cancellationRecords = cancellationRecords;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Room", referencedColumnName = "PK_Room", nullable = false)
    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    @ManyToOne
    @JoinColumn(name = "PK_State", referencedColumnName = "PK_State", nullable = false)
    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Economic_officer", referencedColumnName = "PK_Economic_officer", nullable = false)
    public EconomicOfficerEntity getEconomicOfficer() {
        return economicOfficer;
    }

    public void setEconomicOfficer(EconomicOfficerEntity economicOfficer) {
        this.economicOfficer = economicOfficer;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Accountant", referencedColumnName = "PK_Accountant", nullable = false)
    public AccountantEntity getAccountant() {
        return accountant;
    }

    public void setAccountant(AccountantEntity accountant) {
        this.accountant = accountant;
    }

    @OneToMany(mappedBy = "objectProperty")
    public Collection<RequestRecordEntity> getRequestRecords() {
        return requestRecords;
    }

    public void setRequestRecords(Collection<RequestRecordEntity> requestRecords) {
        this.requestRecords = requestRecords;
    }

    @OneToMany(mappedBy = "objectProperty")
    public Collection<ResultInventoryEntity> getResultInventory() {
        return resultInventory;
    }

    public void setResultInventory(Collection<ResultInventoryEntity> resultInventory) {
        this.resultInventory = resultInventory;
    }
}
