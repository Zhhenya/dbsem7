package com.db.campus.property.security;

import com.db.campus.property.dao.RoleRepository;
import com.db.campus.property.dao.UserRepository;
import com.db.campus.property.entity.UserAccountEntity;
import com.db.campus.property.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final SecurityService securityService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserAccountServiceImpl(SecurityService securityService, RoleRepository roleRepository,
                                  UserRepository userRepository) {
        this.securityService = securityService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createAdminAccount() {
        if (userRepository.findByLogin("admin").isPresent()) {
            return;
        }
        createUserAccount("admin", "passme", Role.ADMIN);
    }

    @Override
    public UserAccountEntity createUserAccount(String login, String password, Role role) {
        UserAccountEntity user = new UserAccountEntity();
        user.setLogin(login);
        user.setPassword(securityService.encodePassword(password));
        user.setRole(roleRepository.findByName(role.name()));
        return userRepository.save(user);
    }
}
