package com.db.campus.property.dao;

import com.db.campus.property.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {

    Iterable<RequestEntity> findAllByUniversityWorker_IdAndStateRequest_Name(long id, String statusName);

}
