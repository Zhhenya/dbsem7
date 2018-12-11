package com.db.campus.property.dao;

import com.db.campus.property.entity.ResultInventoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultInventoryRepository extends CrudRepository<ResultInventoryEntity, Long> {

}
