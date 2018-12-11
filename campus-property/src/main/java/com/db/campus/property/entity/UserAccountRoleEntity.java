package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_account_role", schema = "dbuniver")
public class UserAccountRoleEntity {
    private int id;
    private UserAccountEntity user;
    private RoleEntity role;

    @Id
    @Column(name = "pk_user_account_role", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int pkUserAccountRole) {
        this.id = pkUserAccountRole;
    }

    @ManyToOne
    @JoinColumn(name = "fk_user_account", referencedColumnName = "pk_user_account", nullable = false)
    public UserAccountEntity getUser() {
        return user;
    }

    public void setUser(UserAccountEntity user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "fk_role", referencedColumnName = "pk_role", nullable = false)
    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity roleEntity) {
        this.role = roleEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccountRoleEntity that = (UserAccountRoleEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
