package com.db.campus.property.dao;

import com.db.campus.property.entity.CancellationActEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationActRepository extends CrudRepository<CancellationActEntity, Long> {



}
