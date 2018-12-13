package com.db.campus.property.controller;

import com.db.campus.property.dto.UserAccountDto;
import com.db.campus.property.enums.Role;
import com.db.campus.property.security.SecurityServiceImpl;
import com.db.campus.property.security.UserAccountService;
import com.db.campus.property.service.CampusWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SecurityController {

    private final SecurityServiceImpl securityService;
    private final UserAccountService userAccountService;
    private final CampusWorkerService campusWorkerService;

    @Autowired
    public SecurityController(SecurityServiceImpl securityService,
                              UserAccountService userAccountService,
                              CampusWorkerService campusWorkerService) {
        this.securityService = securityService;
        this.userAccountService = userAccountService;
        this.campusWorkerService = campusWorkerService;
    }

    @RequestMapping("/loginRequest/{login}/{password}")
    @ResponseBody
    public void login(@PathVariable("login") String login, @PathVariable("password") String password) {
        securityService.autoLogin(login, password);
    }

    @RequestMapping("/admin/create")
    @ResponseBody
    public void createAdminAccount() {
        userAccountService.createAdminAccount();
    }

    @RequestMapping(value = "/account/create", method = RequestMethod.POST)
    @ResponseBody
    public Boolean createUserAccount(@RequestBody UserAccountDto userDetails) {
        switch (Role.valueOf(userDetails.getRole())) {
            case ACCOUNTANT:
                campusWorkerService.createAccountantUser(userDetails);
                break;
            case WORKER:
                campusWorkerService.createUniversityWorkerUser(userDetails);
                break;
            case OFFICER:
                campusWorkerService.createEconomicOfficerUser(userDetails);
                break;
        }
        return true;
    }

    @RequestMapping("/roles")
    @ResponseBody
    public List<String> fetchAvailableRoles() {
        return Arrays.stream(Role.values()).map(Enum::name).collect(Collectors.toList());
    }

}
