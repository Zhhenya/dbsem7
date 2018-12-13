package com.db.campus.property.dao;

import com.db.campus.property.entity.EconomicOfficerEntity;
import com.db.campus.property.entity.UserAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EconomicOfficerRepository extends CrudRepository<EconomicOfficerEntity, Long> {

    EconomicOfficerEntity findByUserAccount(UserAccountEntity userAccountEntity);


}
