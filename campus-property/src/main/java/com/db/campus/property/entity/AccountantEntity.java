package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "accountant", schema = "dbuniver")
public class AccountantEntity {
    private String name;
    private long id;
    private Collection<CancellationActEntity> cancellationActs;
    private Collection<ObjectPropertyEntity> objectProperties;
    private Collection<RequestEntity> requests;
    private UserAccountEntity userAccount;

    @Basic
    @Column(name = "A_Name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Accountant", nullable = false, updatable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkAccountant) {
        this.id = pkAccountant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountantEntity that = (AccountantEntity) o;
        return id == that.id &&
               Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @OneToMany(mappedBy = "accountant")
    public Collection<CancellationActEntity> getCancellationActs() {
        return cancellationActs;
    }

    public void setCancellationActs(Collection<CancellationActEntity> cancellationActs) {
        this.cancellationActs = cancellationActs;
    }

    @OneToMany(mappedBy = "accountant")
    public Collection<ObjectPropertyEntity> getObjectProperties() {
        return objectProperties;
    }

    public void setObjectProperties(Collection<ObjectPropertyEntity> objectProperties) {
        this.objectProperties = objectProperties;
    }

    @OneToMany(mappedBy = "accountant")
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
