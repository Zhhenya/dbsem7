package com.db.campus.property.service;

import com.db.campus.property.dao.AccountantRepository;
import com.db.campus.property.dao.EconomicOfficerRepository;
import com.db.campus.property.dao.UniversityWorkerRepository;
import com.db.campus.property.dao.UserRepository;
import com.db.campus.property.dto.UserAccountDto;
import com.db.campus.property.entity.AccountantEntity;
import com.db.campus.property.entity.EconomicOfficerEntity;
import com.db.campus.property.entity.UniversityWorkerEntity;
import com.db.campus.property.entity.UserAccountEntity;
import com.db.campus.property.enums.Role;
import com.db.campus.property.security.UserAccountService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CampusWorkerServiceImpl implements CampusWorkerService {

    private final AccountantRepository accountantRepository;
    private final EconomicOfficerRepository economicOfficerRepository;
    private final UniversityWorkerRepository universityWorkerRepository;
    private final UserRepository userRepository;
    private final UserAccountService userAccountService;

    public CampusWorkerServiceImpl(AccountantRepository accountantRepository,
                                   EconomicOfficerRepository economicOfficerRepository,
                                   UniversityWorkerRepository universityWorkerRepository,
                                   UserRepository userRepository,
                                   UserAccountService userAccountService) {
        this.accountantRepository = accountantRepository;
        this.economicOfficerRepository = economicOfficerRepository;
        this.universityWorkerRepository = universityWorkerRepository;
        this.userRepository = userRepository;
        this.userAccountService = userAccountService;
    }

    @Transactional(readOnly = true)
    @Override
    public UserAccountDto fetchUser(String login) {
        UserAccountEntity userAccountEntity =
                userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));
        UserAccountDto accountDto = new UserAccountDto();
        String role = userAccountEntity.getRole().getName();
        accountDto.setRole(role);
        switch (Role.valueOf(role)) {
            case ACCOUNTANT:
                AccountantEntity accountantEntity = accountantRepository.findByUserAccount(userAccountEntity);
                accountDto.setId(accountantEntity.getId());
                accountDto.setName(accountantEntity.getName());
                break;
            case WORKER:
                UniversityWorkerEntity universityWorkerEntity = universityWorkerRepository.findByUserAccount(userAccountEntity);
                accountDto.setName(universityWorkerEntity.getName());
                accountDto.setId(universityWorkerEntity.getId());
                break;
            case OFFICER:
                EconomicOfficerEntity economicOfficerEntity = economicOfficerRepository.findByUserAccount(userAccountEntity);
                accountDto.setName(economicOfficerEntity.getName());
                accountDto.setId(economicOfficerEntity.getId());
                break;
        }
        return accountDto;
    }

    @Transactional
    @Override
    public AccountantEntity createAccountantUser(UserAccountDto userAccountDto) {
        AccountantEntity accountantEntity = new AccountantEntity();
        accountantEntity.setName(userAccountDto.getName());
        userAccountService.createUserAccount(userAccountDto.getLogin(),
                                             userAccountDto.getPassword(),
                                             Role.ACCOUNTANT);
        accountantEntity.setUserAccount(userRepository.findByLogin(userAccountDto.getLogin())
                                                      .orElseThrow(
                                                              () -> new UsernameNotFoundException(userAccountDto.getLogin())));
        return accountantRepository.save(accountantEntity);
    }

    @Transactional
    @Override
    public EconomicOfficerEntity createEconomicOfficerUser(UserAccountDto userAccountDto) {
        EconomicOfficerEntity economicOfficerEntity = new EconomicOfficerEntity();
        economicOfficerEntity.setName(userAccountDto.getName());
        userAccountService.createUserAccount(userAccountDto.getLogin(),
                                             userAccountDto.getPassword(),
                                             Role.OFFICER);
        economicOfficerEntity.setUserAccount(userRepository.findByLogin(userAccountDto.getLogin())
                                                           .orElseThrow(
                                                                   () -> new UsernameNotFoundException(userAccountDto.getLogin())));
        return economicOfficerRepository.save(economicOfficerEntity);
    }

    @Transactional
    @Override
    public UniversityWorkerEntity createUniversityWorkerUser(UserAccountDto userAccountDto) {
        UniversityWorkerEntity universityWorkerEntity = new UniversityWorkerEntity();
        universityWorkerEntity.setName(userAccountDto.getName());
        userAccountService.createUserAccount(userAccountDto.getLogin(),
                                             userAccountDto.getPassword(),
                                             Role.WORKER);
        universityWorkerEntity.setUserAccount(userRepository.findByLogin(userAccountDto.getLogin())
                                                            .orElseThrow(
                                                                    () -> new UsernameNotFoundException(userAccountDto.getLogin())));
        return universityWorkerRepository.save(universityWorkerEntity);
    }
}
