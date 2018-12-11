package com.db.campus.property.converter;

import com.db.campus.property.dto.AccountantDto;
import com.db.campus.property.entity.AccountantEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountantConverter extends CampusPropertyConverter<AccountantEntity, AccountantDto> {

    @Override
    public AccountantDto convert(AccountantEntity accountantEntity) {
        AccountantDto accountantDto = new AccountantDto();
        accountantDto.setId(accountantEntity.getId());
        accountantDto.setName(accountantEntity.getName());
        return accountantDto;
    }
}
