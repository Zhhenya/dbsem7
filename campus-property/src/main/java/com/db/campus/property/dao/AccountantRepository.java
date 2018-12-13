package com.db.campus.property.dao;

import com.db.campus.property.entity.AccountantEntity;
import com.db.campus.property.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountantRepository extends JpaRepository<AccountantEntity, Long> {

    AccountantEntity findByUserAccount(UserAccountEntity userAccountEntity);

}
