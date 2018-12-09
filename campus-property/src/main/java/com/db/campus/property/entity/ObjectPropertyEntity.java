package com.db.campus.property.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "object_property", schema = "dbuniver", catalog = "")
public class ObjectPropertyEntity {
    private String opCaption;
    private String opPropertyNumber;
    private String opMaker;
    private Date opDate;
    private BigDecimal opCost;
    private long pkObjectProperty;
    private long pkRoom;
    private long pkState;
    private long pkEconomicOfficer;
    private long pkAccountant;
    private Collection<CancellationRecordEntity> cancellationRecordsByPkObjectProperty;
    private RoomEntity roomByPkRoom;
    private StateEntity stateByPkState;
    private EconomicOfficerEntity economicOfficerByPkEconomicOfficer;
    private AccountantEntity accountantByPkAccountant;
    private Collection<RequestRecordEntity> requestRecordsByPkObjectProperty;
    private Collection<ResultinventarisationEntity> resultinventarisationsByPkObjectProperty;

    @Basic
    @Column(name = "OP_Caption", nullable = false, length = 50)
    public String getOpCaption() {
        return opCaption;
    }

    public void setOpCaption(String opCaption) {
        this.opCaption = opCaption;
    }

    @Basic
    @Column(name = "OP_Property_number", nullable = false, length = 50)
    public String getOpPropertyNumber() {
        return opPropertyNumber;
    }

    public void setOpPropertyNumber(String opPropertyNumber) {
        this.opPropertyNumber = opPropertyNumber;
    }

    @Basic
    @Column(name = "OP_Maker", nullable = false, length = 50)
    public String getOpMaker() {
        return opMaker;
    }

    public void setOpMaker(String opMaker) {
        this.opMaker = opMaker;
    }

    @Basic
    @Column(name = "OP_Date", nullable = false)
    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }

    @Basic
    @Column(name = "OP_Cost", nullable = false, precision = 2)
    public BigDecimal getOpCost() {
        return opCost;
    }

    public void setOpCost(BigDecimal opCost) {
        this.opCost = opCost;
    }

    @Id
    @Column(name = "PK_Object_property", nullable = false)
    public long getPkObjectProperty() {
        return pkObjectProperty;
    }

    public void setPkObjectProperty(long pkObjectProperty) {
        this.pkObjectProperty = pkObjectProperty;
    }

    @Basic
    @Column(name = "PK_Room", nullable = false)
    public long getPkRoom() {
        return pkRoom;
    }

    public void setPkRoom(long pkRoom) {
        this.pkRoom = pkRoom;
    }

    @Basic
    @Column(name = "PK_State", nullable = false)
    public long getPkState() {
        return pkState;
    }

    public void setPkState(long pkState) {
        this.pkState = pkState;
    }

    @Basic
    @Column(name = "PK_Economic_officer", nullable = false)
    public long getPkEconomicOfficer() {
        return pkEconomicOfficer;
    }

    public void setPkEconomicOfficer(long pkEconomicOfficer) {
        this.pkEconomicOfficer = pkEconomicOfficer;
    }

    @Basic
    @Column(name = "PK_Accountant", nullable = false)
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
        ObjectPropertyEntity that = (ObjectPropertyEntity) o;
        return pkObjectProperty == that.pkObjectProperty &&
               pkRoom == that.pkRoom &&
               pkState == that.pkState &&
               pkEconomicOfficer == that.pkEconomicOfficer &&
               pkAccountant == that.pkAccountant &&
               Objects.equals(opCaption, that.opCaption) &&
               Objects.equals(opPropertyNumber, that.opPropertyNumber) &&
               Objects.equals(opMaker, that.opMaker) &&
               Objects.equals(opDate, that.opDate) &&
               Objects.equals(opCost, that.opCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opCaption, opPropertyNumber, opMaker, opDate, opCost, pkObjectProperty, pkRoom, pkState, pkEconomicOfficer, pkAccountant);
    }

    @OneToMany(mappedBy = "objectPropertyByPkObjectProperty")
    public Collection<CancellationRecordEntity> getCancellationRecordsByPkObjectProperty() {
        return cancellationRecordsByPkObjectProperty;
    }

    public void setCancellationRecordsByPkObjectProperty(Collection<CancellationRecordEntity> cancellationRecordsByPkObjectProperty) {
        this.cancellationRecordsByPkObjectProperty = cancellationRecordsByPkObjectProperty;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Room", referencedColumnName = "PK_Room", nullable = false)
    public RoomEntity getRoomByPkRoom() {
        return roomByPkRoom;
    }

    public void setRoomByPkRoom(RoomEntity roomByPkRoom) {
        this.roomByPkRoom = roomByPkRoom;
    }

    @ManyToOne
    @JoinColumn(name = "PK_State", referencedColumnName = "PK_State", nullable = false)
    public StateEntity getStateByPkState() {
        return stateByPkState;
    }

    public void setStateByPkState(StateEntity stateByPkState) {
        this.stateByPkState = stateByPkState;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Economic_officer", referencedColumnName = "PK_Economic_officer", nullable = false)
    public EconomicOfficerEntity getEconomicOfficerByPkEconomicOfficer() {
        return economicOfficerByPkEconomicOfficer;
    }

    public void setEconomicOfficerByPkEconomicOfficer(EconomicOfficerEntity economicOfficerByPkEconomicOfficer) {
        this.economicOfficerByPkEconomicOfficer = economicOfficerByPkEconomicOfficer;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Accountant", referencedColumnName = "PK_Accountant", nullable = false)
    public AccountantEntity getAccountantByPkAccountant() {
        return accountantByPkAccountant;
    }

    public void setAccountantByPkAccountant(AccountantEntity accountantByPkAccountant) {
        this.accountantByPkAccountant = accountantByPkAccountant;
    }

    @OneToMany(mappedBy = "objectPropertyByPkObjectProperty")
    public Collection<RequestRecordEntity> getRequestRecordsByPkObjectProperty() {
        return requestRecordsByPkObjectProperty;
    }

    public void setRequestRecordsByPkObjectProperty(Collection<RequestRecordEntity> requestRecordsByPkObjectProperty) {
        this.requestRecordsByPkObjectProperty = requestRecordsByPkObjectProperty;
    }

    @OneToMany(mappedBy = "objectPropertyByPkObjectProperty")
    public Collection<ResultinventarisationEntity> getResultinventarisationsByPkObjectProperty() {
        return resultinventarisationsByPkObjectProperty;
    }

    public void setResultinventarisationsByPkObjectProperty(Collection<ResultinventarisationEntity> resultinventarisationsByPkObjectProperty) {
        this.resultinventarisationsByPkObjectProperty = resultinventarisationsByPkObjectProperty;
    }
}
