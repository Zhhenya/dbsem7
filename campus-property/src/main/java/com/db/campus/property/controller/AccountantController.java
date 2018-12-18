package com.db.campus.property.controller;

import com.db.campus.property.converter.AccountantConverter;
import com.db.campus.property.dao.AccountantRepository;
import com.db.campus.property.dto.AccountantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountantController {

    private final AccountantRepository accountantRepository;
    private final AccountantConverter accountantConverter;

    @Autowired
    public AccountantController(AccountantRepository accountantRepository, AccountantConverter accountantConverter) {
        this.accountantRepository = accountantRepository;
        this.accountantConverter = accountantConverter;
    }

    @RequestMapping("accountant/all")
    @ResponseBody
    public List<AccountantDto> fetchAll() {
        return accountantConverter.convertAll(accountantRepository.findAll());
    }
}
