package com.db.campus.property.controller;

import com.db.campus.property.dto.UserAccountDto;
import com.db.campus.property.enums.Role;
import com.db.campus.property.security.SecurityServiceImpl;
import com.db.campus.property.security.UserAccountService;
import com.db.campus.property.service.CampusWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/loginRequest", method = RequestMethod.POST)
    @ResponseBody
    public Boolean login(@RequestBody UserAccountDto userDetails) {
        securityService.login(userDetails.getLogin(), userDetails.getPassword());
        return true;
    }

    @RequestMapping(value = "/logoutRequest", method = RequestMethod.POST)
    @ResponseBody
    public Boolean logout(HttpServletRequest request, HttpServletResponse response) {
        securityService.logout(request, response);
        return true;
    }

    @RequestMapping("/loggedIn")
    @ResponseBody
    public UserAccountDto fetchLoggedInUser() {
        return campusWorkerService.fetchUser(securityService.findLoggedInUsername());
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

    @RequestMapping("/admin/users")
    @ResponseBody
    public List<UserAccountDto> getAllUsers() {
        return securityService.getAllUsers();
    }

    @RequestMapping("/roles")
    @ResponseBody
    public List<String> fetchAvailableRoles() {
        return Arrays.stream(Role.values()).map(Enum::name).collect(Collectors.toList());
    }

}
