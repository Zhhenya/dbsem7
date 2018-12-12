package com.db.campus.property.security;

import com.db.campus.property.entity.UserAccountEntity;
import com.db.campus.property.enums.Role;

public interface UserAccountService {

    void createAdminAccount();

    UserAccountEntity createUserAccount(String login, String password, Role role);

}
