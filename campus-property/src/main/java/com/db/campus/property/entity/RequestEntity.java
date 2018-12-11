package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "request", schema = "dbuniver")
public class RequestEntity {
    private String content;
    private long id;
    private TypeRequestEntity typeRequest;
    private StateRequestEntity stateRequest;
    private UniversityWorkerEntity universityWorker;
    private EconomicOfficerEntity economicOfficer;
    private AccountantEntity accountant;
    private Collection<RequestRecordEntity> requestRecords;

    @Basic
    @Column(name = "Req_Content", nullable = false, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String reqContent) {
        this.content = reqContent;
    }

    @Id
    @Column(name = "PK_Request", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkRequest) {
        this.id = pkRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestEntity that = (RequestEntity) o;
        return id == that.id &&
               Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, id);
    }

    @ManyToOne
    @JoinColumn(name = "PK_Type_request", referencedColumnName = "PK_Type_request", nullable = false)
    public TypeRequestEntity getTypeRequest() {
        return typeRequest;
    }

    public void setTypeRequest(TypeRequestEntity typeRequest) {
        this.typeRequest = typeRequest;
    }

    @ManyToOne
    @JoinColumn(name = "PK_State_request", referencedColumnName = "PK_State_request")
    public StateRequestEntity getStateRequest() {
        return stateRequest;
    }

    public void setStateRequest(StateRequestEntity stateRequest) {
        this.stateRequest = stateRequest;
    }

    @ManyToOne
    @JoinColumn(name = "PK_University_worker", referencedColumnName = "PK_University_worker",
            nullable = false)
    public UniversityWorkerEntity getUniversityWorker() {
        return universityWorker;
    }

    public void setUniversityWorker(UniversityWorkerEntity universityWorker) {
        this.universityWorker = universityWorker;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Economic_officer", referencedColumnName = "PK_Economic_officer")
    public EconomicOfficerEntity getEconomicOfficer() {
        return economicOfficer;
    }

    public void setEconomicOfficer(EconomicOfficerEntity economicOfficer) {
        this.economicOfficer = economicOfficer;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Accountant", referencedColumnName = "PK_Accountant")
    public AccountantEntity getAccountant() {
        return accountant;
    }

    public void setAccountant(AccountantEntity accountant) {
        this.accountant = accountant;
    }

    @OneToMany(mappedBy = "request")
    public Collection<RequestRecordEntity> getRequestRecords() {
        return requestRecords;
    }

    public void setRequestRecords(Collection<RequestRecordEntity> requestRecords) {
        this.requestRecords = requestRecords;
    }
}
