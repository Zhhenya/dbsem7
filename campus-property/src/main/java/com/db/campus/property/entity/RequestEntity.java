package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "request", schema = "dbuniver", catalog = "")
public class RequestEntity {
    private String reqContent;
    private long pkRequest;
    private long pkTypeRequest;
    private Long pkStateRequest;
    private long pkUniversityWorker;
    private Long pkEconomicOfficer;
    private Long pkAccountant;
    private TypeRequestEntity typeRequestByPkTypeRequest;
    private StateRequestEntity stateRequestByPkStateRequest;
    private UniversityWorkerEntity universityWorkerByPkUniversityWorker;
    private EconomicOfficerEntity economicOfficerByPkEconomicOfficer;
    private AccountantEntity accountantByPkAccountant;
    private Collection<RequestRecordEntity> requestRecordsByPkRequest;

    @Basic
    @Column(name = "Req_Content", nullable = false, length = 500)
    public String getReqContent() {
        return reqContent;
    }

    public void setReqContent(String reqContent) {
        this.reqContent = reqContent;
    }

    @Id
    @Column(name = "PK_Request", nullable = false)
    public long getPkRequest() {
        return pkRequest;
    }

    public void setPkRequest(long pkRequest) {
        this.pkRequest = pkRequest;
    }

    @Basic
    @Column(name = "PK_Type_request", nullable = false)
    public long getPkTypeRequest() {
        return pkTypeRequest;
    }

    public void setPkTypeRequest(long pkTypeRequest) {
        this.pkTypeRequest = pkTypeRequest;
    }

    @Basic
    @Column(name = "PK_State_request", nullable = true)
    public Long getPkStateRequest() {
        return pkStateRequest;
    }

    public void setPkStateRequest(Long pkStateRequest) {
        this.pkStateRequest = pkStateRequest;
    }

    @Basic
    @Column(name = "PK_University_worker", nullable = false)
    public long getPkUniversityWorker() {
        return pkUniversityWorker;
    }

    public void setPkUniversityWorker(long pkUniversityWorker) {
        this.pkUniversityWorker = pkUniversityWorker;
    }

    @Basic
    @Column(name = "PK_Economic_officer", nullable = true)
    public Long getPkEconomicOfficer() {
        return pkEconomicOfficer;
    }

    public void setPkEconomicOfficer(Long pkEconomicOfficer) {
        this.pkEconomicOfficer = pkEconomicOfficer;
    }

    @Basic
    @Column(name = "PK_Accountant", nullable = true)
    public Long getPkAccountant() {
        return pkAccountant;
    }

    public void setPkAccountant(Long pkAccountant) {
        this.pkAccountant = pkAccountant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestEntity that = (RequestEntity) o;
        return pkRequest == that.pkRequest &&
               pkTypeRequest == that.pkTypeRequest &&
               pkUniversityWorker == that.pkUniversityWorker &&
               Objects.equals(reqContent, that.reqContent) &&
               Objects.equals(pkStateRequest, that.pkStateRequest) &&
               Objects.equals(pkEconomicOfficer, that.pkEconomicOfficer) &&
               Objects.equals(pkAccountant, that.pkAccountant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqContent, pkRequest, pkTypeRequest, pkStateRequest, pkUniversityWorker, pkEconomicOfficer, pkAccountant);
    }

    @ManyToOne
    @JoinColumn(name = "PK_Type_request", referencedColumnName = "PK_Type_request", nullable = false)
    public TypeRequestEntity getTypeRequestByPkTypeRequest() {
        return typeRequestByPkTypeRequest;
    }

    public void setTypeRequestByPkTypeRequest(TypeRequestEntity typeRequestByPkTypeRequest) {
        this.typeRequestByPkTypeRequest = typeRequestByPkTypeRequest;
    }

    @ManyToOne
    @JoinColumn(name = "PK_State_request", referencedColumnName = "PK_State_request")
    public StateRequestEntity getStateRequestByPkStateRequest() {
        return stateRequestByPkStateRequest;
    }

    public void setStateRequestByPkStateRequest(StateRequestEntity stateRequestByPkStateRequest) {
        this.stateRequestByPkStateRequest = stateRequestByPkStateRequest;
    }

    @ManyToOne
    @JoinColumn(name = "PK_University_worker", referencedColumnName = "PK_University_worker",
            nullable = false)
    public UniversityWorkerEntity getUniversityWorkerByPkUniversityWorker() {
        return universityWorkerByPkUniversityWorker;
    }

    public void setUniversityWorkerByPkUniversityWorker(UniversityWorkerEntity universityWorkerByPkUniversityWorker) {
        this.universityWorkerByPkUniversityWorker = universityWorkerByPkUniversityWorker;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Economic_officer", referencedColumnName = "PK_Economic_officer")
    public EconomicOfficerEntity getEconomicOfficerByPkEconomicOfficer() {
        return economicOfficerByPkEconomicOfficer;
    }

    public void setEconomicOfficerByPkEconomicOfficer(EconomicOfficerEntity economicOfficerByPkEconomicOfficer) {
        this.economicOfficerByPkEconomicOfficer = economicOfficerByPkEconomicOfficer;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Accountant", referencedColumnName = "PK_Accountant")
    public AccountantEntity getAccountantByPkAccountant() {
        return accountantByPkAccountant;
    }

    public void setAccountantByPkAccountant(AccountantEntity accountantByPkAccountant) {
        this.accountantByPkAccountant = accountantByPkAccountant;
    }

    @OneToMany(mappedBy = "requestByPkRequest")
    public Collection<RequestRecordEntity> getRequestRecordsByPkRequest() {
        return requestRecordsByPkRequest;
    }

    public void setRequestRecordsByPkRequest(Collection<RequestRecordEntity> requestRecordsByPkRequest) {
        this.requestRecordsByPkRequest = requestRecordsByPkRequest;
    }
}
