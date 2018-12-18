package com.db.campus.property.service.accountant;

import com.db.campus.property.dto.AccountantDto;

import java.util.List;

public interface AccountantService {

    List<AccountantDto> findAll();

    void save(AccountantDto accountantDto);

}
