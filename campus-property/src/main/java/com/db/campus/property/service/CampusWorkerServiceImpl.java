package com.db.campus.property.service;

import com.db.campus.property.dao.AccountantRepository;
import com.db.campus.property.dao.EconomicOfficerRepository;
import com.db.campus.property.dao.UniversityWorkerRepository;
import com.db.campus.property.dto.UserAccountDto;
import com.db.campus.property.entity.AccountantEntity;
import com.db.campus.property.entity.EconomicOfficerEntity;
import com.db.campus.property.entity.UniversityWorkerEntity;
import com.db.campus.property.enums.Role;
import com.db.campus.property.security.UserAccountService;
import org.springframework.stereotype.Service;

@Service
public class CampusWorkerServiceImpl implements CampusWorkerService {

    private final AccountantRepository accountantRepository;
    private final EconomicOfficerRepository economicOfficerRepository;
    private final UniversityWorkerRepository universityWorkerRepository;
    private final UserAccountService userAccountService;

    public CampusWorkerServiceImpl(AccountantRepository accountantRepository,
                                   EconomicOfficerRepository economicOfficerRepository,
                                   UniversityWorkerRepository universityWorkerRepository,
                                   UserAccountService userAccountService) {
        this.accountantRepository = accountantRepository;
        this.economicOfficerRepository = economicOfficerRepository;
        this.universityWorkerRepository = universityWorkerRepository;
        this.userAccountService = userAccountService;
    }

    @Override
    public AccountantEntity createAccountantUser(UserAccountDto userAccountDto) {
        AccountantEntity accountantEntity = new AccountantEntity();
        accountantEntity.setName(userAccountDto.getName());
        accountantEntity.setUserAccount(userAccountService.createUserAccount(userAccountDto.getLogin(),
                                                                             userAccountDto.getPassword(),
                                                                             Role.ACCOUNTANT));
        return accountantRepository.save(accountantEntity);
    }

    @Override
    public EconomicOfficerEntity createEconomicOfficerUser(UserAccountDto userAccountDto) {
        EconomicOfficerEntity economicOfficerEntity = new EconomicOfficerEntity();
        economicOfficerEntity.setName(userAccountDto.getName());
        economicOfficerEntity.setUserAccount(userAccountService.createUserAccount(userAccountDto.getLogin(),
                                                                             userAccountDto.getPassword(),
                                                                             Role.OFFICER));
        return economicOfficerRepository.save(economicOfficerEntity);
    }

    @Override
    public UniversityWorkerEntity createUniversityWorkerUser(UserAccountDto userAccountDto) {
        UniversityWorkerEntity universityWorkerEntity = new UniversityWorkerEntity();
        universityWorkerEntity.setName(userAccountDto.getName());
        universityWorkerEntity.setUserAccount(userAccountService.createUserAccount(userAccountDto.getLogin(),
                                                                                  userAccountDto.getPassword(),
                                                                                  Role.WORKER));
        return universityWorkerRepository.save(universityWorkerEntity);
    }
}
