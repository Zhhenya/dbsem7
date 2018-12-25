package com.db.campus.property.service.inventory;

import com.db.campus.property.dto.InventoryDto;

import java.util.List;

public interface InventoryService {

    List<InventoryDto> fetchInventoryList();

    void initInventory();
}
