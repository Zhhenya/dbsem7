package com.db.campus.property.dao;

import com.db.campus.property.entity.CancellationActEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationActRepository extends JpaRepository<CancellationActEntity, Long> {



}
