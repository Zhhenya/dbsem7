package com.db.campus.property.dao;

import com.db.campus.property.entity.ObjectPropertyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectPropertyRepository extends CrudRepository<ObjectPropertyEntity, Long> {



}
