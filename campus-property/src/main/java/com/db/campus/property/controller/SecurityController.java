package com.db.campus.property.controller;

import com.db.campus.property.security.SecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    private final SecurityServiceImpl securityService;

    @Autowired
    public SecurityController(SecurityServiceImpl securityService) {this.securityService = securityService;}

    @RequestMapping("/loginRequest/{login}/{password}")
    @ResponseBody
    public void login(@PathVariable("login") String login, @PathVariable("password") String password) {
        securityService.autoLogin(login, password);
    }

}
