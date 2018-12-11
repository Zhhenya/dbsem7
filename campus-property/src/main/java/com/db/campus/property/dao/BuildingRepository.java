package com.db.campus.property.dao;

import com.db.campus.property.entity.BuildingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends CrudRepository<BuildingEntity, Long> {



}
