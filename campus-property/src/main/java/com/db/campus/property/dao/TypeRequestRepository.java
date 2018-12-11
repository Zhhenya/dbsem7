package com.db.campus.property.dao;

import com.db.campus.property.entity.TypeRequestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRequestRepository extends CrudRepository<TypeRequestEntity, Long> {

}
