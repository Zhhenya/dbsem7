package com.db.campus.property.dao;

import com.db.campus.property.entity.StateRequestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRequestRepository extends CrudRepository<StateRequestEntity, Long> {

}
