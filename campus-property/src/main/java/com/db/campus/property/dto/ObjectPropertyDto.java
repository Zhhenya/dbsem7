package com.db.campus.property.dto;

public class ObjectPropertyDto {

    private Long id;
    private String caption;
    private String propertyNumber;
    private String maker;
    private String date;
    private String cost;
    private RoomDto room;
    private String state;
    private EconomicOfficerDto economicOfficer;
    private AccountantDto accountant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public EconomicOfficerDto getEconomicOfficer() {
        return economicOfficer;
    }

    public void setEconomicOfficer(EconomicOfficerDto economicOfficer) {
        this.economicOfficer = economicOfficer;
    }

    public AccountantDto getAccountant() {
        return accountant;
    }

    public void setAccountant(AccountantDto accountant) {
        this.accountant = accountant;
    }
}
