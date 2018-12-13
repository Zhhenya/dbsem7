package com.db.campus.property.dao;

import com.db.campus.property.entity.StateRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRequestRepository extends JpaRepository<StateRequestEntity, Long> {

    StateRequestEntity findByName(String name);

}
