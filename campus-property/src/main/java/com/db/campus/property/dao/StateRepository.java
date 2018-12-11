package com.db.campus.property.dao;

import com.db.campus.property.entity.StateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<StateEntity, Long> {

}
