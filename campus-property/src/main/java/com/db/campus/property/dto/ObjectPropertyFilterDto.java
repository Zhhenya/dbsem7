package com.db.campus.property.dto;

import java.util.Date;

public class ObjectPropertyFilterDto {

    private String caption;
    private String numberGreater;
    private String numberLess;
    private String maker;
    private Date dateLater;
    private Date dateEarlier;
    private Double costGreater;
    private Double costLess;
    private RoomDto room;
    private BuildingDto building;
    private String state;
    private EconomicOfficerDto officer;
    private AccountantDto accountant;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getNumberGreater() {
        return numberGreater;
    }

    public void setNumberGreater(String numberGreater) {
        this.numberGreater = numberGreater;
    }

    public String getNumberLess() {
        return numberLess;
    }

    public void setNumberLess(String numberLess) {
        this.numberLess = numberLess;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Date getDateLater() {
        return dateLater;
    }

    public void setDateLater(Date dateLater) {
        this.dateLater = dateLater;
    }

    public Date getDateEarlier() {
        return dateEarlier;
    }

    public void setDateEarlier(Date dateEarlier) {
        this.dateEarlier = dateEarlier;
    }

    public Double getCostGreater() {
        return costGreater;
    }

    public void setCostGreater(Double costGreater) {
        this.costGreater = costGreater;
    }

    public Double getCostLess() {
        return costLess;
    }

    public void setCostLess(Double costLess) {
        this.costLess = costLess;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }

    public BuildingDto getBuilding() {
        return building;
    }

    public void setBuilding(BuildingDto building) {
        this.building = building;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public EconomicOfficerDto getOfficer() {
        return officer;
    }

    public void setOfficer(EconomicOfficerDto officer) {
        this.officer = officer;
    }

    public AccountantDto getAccountant() {
        return accountant;
    }

    public void setAccountant(AccountantDto accountant) {
        this.accountant = accountant;
    }
}
