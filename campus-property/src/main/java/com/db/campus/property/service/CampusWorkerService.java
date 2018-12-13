package com.db.campus.property.service;

import com.db.campus.property.dto.UserAccountDto;
import com.db.campus.property.entity.AccountantEntity;
import com.db.campus.property.entity.EconomicOfficerEntity;
import com.db.campus.property.entity.UniversityWorkerEntity;

public interface CampusWorkerService {

    AccountantEntity createAccountantUser(UserAccountDto userAccountDto);

    EconomicOfficerEntity createEconomicOfficerUser(UserAccountDto userAccountDto);

    UniversityWorkerEntity createUniversityWorkerUser(UserAccountDto userAccountDto);

    UserAccountDto fetchUser(String login);

}
