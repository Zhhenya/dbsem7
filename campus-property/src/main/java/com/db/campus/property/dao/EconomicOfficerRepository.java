package com.db.campus.property.dao;

import com.db.campus.property.entity.EconomicOfficerEntity;
import com.db.campus.property.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EconomicOfficerRepository extends JpaRepository<EconomicOfficerEntity, Long> {

    EconomicOfficerEntity findByUserAccount(UserAccountEntity userAccountEntity);

}
