package com.db.campus.property.dao;

import com.db.campus.property.entity.InventoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<InventoryEntity, Long> {



}
