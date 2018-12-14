package com.db.campus.property.dao;

import com.db.campus.property.entity.CancellationRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationRecordRepository extends JpaRepository<CancellationRecordEntity, Long> {



}
