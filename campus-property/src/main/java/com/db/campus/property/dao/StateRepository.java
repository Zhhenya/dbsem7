package com.db.campus.property.dao;

import com.db.campus.property.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long> {

    StateEntity findByName(String name);

}
