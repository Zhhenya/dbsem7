package com.db.campus.property.dao;

import com.db.campus.property.entity.TypeRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRequestRepository extends JpaRepository<TypeRequestEntity, Long> {

    TypeRequestEntity findByName(String name);

}
