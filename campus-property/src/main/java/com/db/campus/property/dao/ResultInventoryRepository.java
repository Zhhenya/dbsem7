package com.db.campus.property.dao;

import com.db.campus.property.entity.ResultInventoryEntity;
import com.db.campus.property.entity.ResultInventoryEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultInventoryRepository extends JpaRepository<ResultInventoryEntity, ResultInventoryEntityPK> {

    Iterable<ResultInventoryEntity> findAllByInventory_Id(long inventoryId);

    Iterable<ResultInventoryEntity> findAllByInventory_IdAndObjectProperty_Room_Id(long inventoryId, long roomId);

}
