package com.db.campus.property.controller;

import com.db.campus.property.dto.AccountantDto;
import com.db.campus.property.service.accountant.AccountantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountantController {

    private final AccountantService accountantService;

    @Autowired
    public AccountantController(AccountantService accountantService) {
        this.accountantService = accountantService;
    }

    @RequestMapping("accountant/all")
    @ResponseBody
    public List<AccountantDto> fetchAll() {
        return accountantService.findAll();
    }

    @RequestMapping(value = "accountant/save", method = RequestMethod.POST)
    @ResponseBody
    public Boolean save(@RequestBody AccountantDto accountantDto) {
        accountantService.save(accountantDto);
        return true;
    }
}
