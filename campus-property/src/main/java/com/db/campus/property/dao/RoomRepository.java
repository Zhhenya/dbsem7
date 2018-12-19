package com.db.campus.property.dao;

import com.db.campus.property.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    @Query("SELECT DISTINCT number FROM RoomEntity")
    List<Long> findAllNumbers();

}
