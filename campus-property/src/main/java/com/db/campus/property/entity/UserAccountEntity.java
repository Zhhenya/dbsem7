package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_account", schema = "dbuniver")
public class UserAccountEntity {
    private int id;
    private String login;
    private String password;
    private RoleEntity role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_user_account", nullable = false, updatable = false)
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

    @ManyToOne
    @JoinColumn(name = "fk_role", referencedColumnName = "pk_role", nullable = false)
    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
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
