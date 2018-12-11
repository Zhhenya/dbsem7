package com.db.campus.property.controller;

import com.db.campus.property.dao.AccountantRepository;
import com.db.campus.property.dao.RoleRepository;
import com.db.campus.property.dao.UserRepository;
import com.db.campus.property.security.SecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final AccountantRepository accountantRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final SecurityServiceImpl securityService;

    @Autowired
    public TestController(AccountantRepository accountantRepository, RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, SecurityServiceImpl securityService) {
        this.accountantRepository = accountantRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.securityService = securityService;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String getHelloString() {
        /*AccountantEntity accountantEntity = accountantRepository.findById(1L).get();
        UserAccountEntity userAccountEntity = new UserAccountEntity();
        userAccountEntity.setLogin("ZHULITOV-MV");
        userAccountEntity.setPassword(bCryptPasswordEncoder.encode("ZHULITOV-MV-pass"));
        userAccountEntity.setRole(roleRepository.findById(2).get());
        userAccountEntity = userRepository.save(userAccountEntity);
        accountantEntity.setUserAccount(userRepository.findById(1).get());
        accountantRepository.save(accountantEntity);*/
        securityService.autoLogin("ZHULITOV-MV", "ZHULITOV-MV-pass");
        return "Hello World";
    }

}
