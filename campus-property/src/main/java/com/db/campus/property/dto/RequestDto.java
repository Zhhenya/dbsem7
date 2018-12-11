package com.db.campus.property.dto;

import java.util.List;

public class RequestDto {

    private Long id;
    private String content;
    private String type;
    private String state;
    private String universityWorker;
    private String economicOfficer;
    private String accountant;
    private List<String> records;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUniversityWorker() {
        return universityWorker;
    }

    public void setUniversityWorker(String universityWorker) {
        this.universityWorker = universityWorker;
    }

    public String getEconomicOfficer() {
        return economicOfficer;
    }

    public void setEconomicOfficer(String economicOfficer) {
        this.economicOfficer = economicOfficer;
    }

    public String getAccountant() {
        return accountant;
    }

    public void setAccountant(String accountant) {
        this.accountant = accountant;
    }

    public List<String> getRecords() {
        return records;
    }

    public void setRecords(List<String> records) {
        this.records = records;
    }
}
