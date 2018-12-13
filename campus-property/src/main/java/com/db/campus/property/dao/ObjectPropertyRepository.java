package com.db.campus.property.dao;

import com.db.campus.property.entity.ObjectPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectPropertyRepository extends JpaRepository<ObjectPropertyEntity, Long> {

    ObjectPropertyEntity findByPropertyNumber(String number);

}
