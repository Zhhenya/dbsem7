package com.db.campus.property.dto;

import java.util.ArrayList;
import java.util.List;

public class RequestDto {

    private Long id;
    private String content;
    private String type;
    private String state;
    private UniversityWorkerDto universityWorker;
    private EconomicOfficerDto economicOfficer;
    private AccountantDto accountant;
    private List<RequestRecordDto> requestRecordList = new ArrayList<>();

    public List<RequestRecordDto> getRequestRecordList() {
        return requestRecordList;
    }

    public void setRequestRecordList(List<RequestRecordDto> requestRecordList) {
        this.requestRecordList = requestRecordList;
    }

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

    public UniversityWorkerDto getUniversityWorker() {
        return universityWorker;
    }

    public void setUniversityWorker(UniversityWorkerDto universityWorker) {
        this.universityWorker = universityWorker;
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
