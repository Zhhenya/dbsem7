package com.db.campus.property.dao;

import com.db.campus.property.entity.UniversityWorkerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityWorkerRepository extends CrudRepository<UniversityWorkerEntity, Long> {

}
