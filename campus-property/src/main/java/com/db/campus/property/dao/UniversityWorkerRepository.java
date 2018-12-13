package com.db.campus.property.dao;

import com.db.campus.property.entity.UniversityWorkerEntity;
import com.db.campus.property.entity.UserAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityWorkerRepository extends CrudRepository<UniversityWorkerEntity, Long> {

    UniversityWorkerEntity findByUserAccount(UserAccountEntity userAccountEntity);


}
