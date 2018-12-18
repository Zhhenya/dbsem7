package com.db.campus.property.dao;

import com.db.campus.property.entity.ObjectPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjectPropertyRepository extends JpaRepository<ObjectPropertyEntity, Long> {

    Optional<ObjectPropertyEntity> findByPropertyNumber(String number);

    @Query("SELECT DISTINCT maker FROM ObjectPropertyEntity")
    List<String> findDistinctMakers();

}
