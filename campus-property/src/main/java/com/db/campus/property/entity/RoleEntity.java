package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "dbuniver")
public class RoleEntity {
    private int id;
    private String name;
    private Collection<UserAccountEntity> userAccountEntities;

    @Id
    @Column(name = "pk_role", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int pkRole) {
        this.id = pkRole;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "role")
    public Collection<UserAccountEntity> getUserAccountEntities() {
        return userAccountEntities;
    }

    public void setUserAccountEntities(Collection<UserAccountEntity> userAccountEntities) {
        this.userAccountEntities = userAccountEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return id == that.id &&
               Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
