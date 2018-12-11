package com.db.campus.property.dao;

import com.db.campus.property.entity.CancellationRecordEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationRecordRepository extends CrudRepository<CancellationRecordEntity, Long> {



}
