package com.db.campus.property.service.accountant;

import com.db.campus.property.converter.AccountantConverter;
import com.db.campus.property.dao.AccountantRepository;
import com.db.campus.property.dto.AccountantDto;
import com.db.campus.property.entity.AccountantEntity;
import com.db.campus.property.exception.WorkerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountantServiceImpl implements AccountantService {

    private final AccountantRepository accountantRepository;
    private final AccountantConverter accountantConverter;

    @Autowired
    public AccountantServiceImpl(AccountantRepository accountantRepository, AccountantConverter accountantConverter) {
        this.accountantRepository = accountantRepository;
        this.accountantConverter = accountantConverter;
    }

    @Override
    public List<AccountantDto> findAll() {
        return accountantConverter.convertAll(accountantRepository.findAll());
    }

    @Override
    public void save(AccountantDto accountantDto) {
        AccountantEntity accountantEntity = accountantRepository.findById(accountantDto.getId())
                                                                .orElseThrow(() -> new WorkerNotFoundException(
                                                                        accountantDto.getName()));
        accountantEntity.setName(accountantDto.getName());
        accountantRepository.save(accountantEntity);
    }
}
