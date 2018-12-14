package com.db.campus.property.dao;

import com.db.campus.property.entity.RequestRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRecordRepository extends JpaRepository<RequestRecordEntity, Long> {

}
