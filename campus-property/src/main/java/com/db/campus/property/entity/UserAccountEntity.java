package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user_account", schema = "dbuniver")
public class UserAccountEntity {
    private int id;
    private String login;
    private String password;
    private Collection<UserAccountRoleEntity> userAccountRoleEntities;

    @Id
    @Column(name = "pk_user_account", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int pkUserAccount) {
        this.id = pkUserAccount;
    }

    @Basic
    @Column(name = "user_login", nullable = false, length = 255)
    public String getLogin() {
        return login;
    }

    public void setLogin(String userLogin) {
        this.login = userLogin;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    @OneToMany(mappedBy = "user")
    public Collection<UserAccountRoleEntity> getUserAccountRoleEntities() {
        return userAccountRoleEntities;
    }

    public void setUserAccountRoleEntities(Collection<UserAccountRoleEntity> userAccountRoleEntities) {
        this.userAccountRoleEntities = userAccountRoleEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccountEntity that = (UserAccountEntity) o;
        return id == that.id &&
               Objects.equals(login, that.login) &&
               Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}
