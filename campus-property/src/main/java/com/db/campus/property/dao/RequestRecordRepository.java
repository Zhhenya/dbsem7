package com.db.campus.property.dao;

import com.db.campus.property.entity.RequestRecordEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRecordRepository extends CrudRepository<RequestRecordEntity, Long> {

}
