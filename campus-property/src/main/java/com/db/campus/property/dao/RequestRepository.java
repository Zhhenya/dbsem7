package com.db.campus.property.dao;

import com.db.campus.property.entity.RequestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<RequestEntity, Long> {

}
