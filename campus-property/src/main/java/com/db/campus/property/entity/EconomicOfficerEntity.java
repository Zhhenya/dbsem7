package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "economic_officer", schema = "dbuniver")
public class EconomicOfficerEntity {
    private String name;
    private long id;
    private String email;
    private Collection<ObjectPropertyEntity> objectProperties;
    private Collection<RequestEntity> requests;
    private UserAccountEntity userAccount;

    @Basic
    @Column(name = "EO_Name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String eoName) {
        this.name = eoName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Economic_officer", nullable = false, updatable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkEconomicOfficer) {
        this.id = pkEconomicOfficer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EconomicOfficerEntity that = (EconomicOfficerEntity) o;
        return id == that.id &&
               Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @OneToMany(mappedBy = "economicOfficer")
    public Collection<ObjectPropertyEntity> getObjectProperties() {
        return objectProperties;
    }

    public void setObjectProperties(Collection<ObjectPropertyEntity> objectProperties) {
        this.objectProperties = objectProperties;
    }

    @OneToMany(mappedBy = "economicOfficer")
    public Collection<RequestEntity> getRequests() {
        return requests;
    }

    public void setRequests(Collection<RequestEntity> requests) {
        this.requests = requests;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_user", nullable = false)
    public UserAccountEntity getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountEntity userAccount) {
        this.userAccount = userAccount;
    }
}
