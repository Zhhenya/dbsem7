package com.db.campus.property.dto;

import java.util.ArrayList;
import java.util.List;

public class CancellationActDto {

    private Long id;
    private String date;
    private AccountantDto accountant;
    private List<CancellationRecordDto> records = new ArrayList<>();

    public List<CancellationRecordDto> getRecords() {
        return records;
    }

    public void setRecords(List<CancellationRecordDto> records) {
        this.records = records;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public AccountantDto getAccountant() {
        return accountant;
    }

    public void setAccountant(AccountantDto accountant) {
        this.accountant = accountant;
    }
}
