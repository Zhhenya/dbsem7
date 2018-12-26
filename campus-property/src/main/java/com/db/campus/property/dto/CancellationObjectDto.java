package com.db.campus.property.dto;

public class CancellationObjectDto {

    private ObjectPropertyDto object;
    private String reason;
    private AccountantDto accountant;

    public ObjectPropertyDto getObject() {
        return object;
    }

    public void setObject(ObjectPropertyDto object) {
        this.object = object;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public AccountantDto getAccountant() {
        return accountant;
    }

    public void setAccountant(AccountantDto accountant) {
        this.accountant = accountant;
    }
}
