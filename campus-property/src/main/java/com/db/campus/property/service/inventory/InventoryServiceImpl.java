package com.db.campus.property.service.inventory;

import com.db.campus.property.converter.InventoryConverter;
import com.db.campus.property.dao.StoredProcedureProvider;
import com.db.campus.property.dao.inventory.InventoryRepository;
import com.db.campus.property.dto.InventoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryConverter inventoryConverter;
    private final InventoryRepository inventoryRepository;
    private final StoredProcedureProvider storedProcedureProvider;

    @Autowired
    public InventoryServiceImpl(InventoryConverter inventoryConverter,
                                InventoryRepository inventoryRepository,
                                StoredProcedureProvider storedProcedureProvider) {
        this.inventoryConverter = inventoryConverter;
        this.inventoryRepository = inventoryRepository;
        this.storedProcedureProvider = storedProcedureProvider;
    }

    @Transactional(readOnly = true)
    @Override
    public List<InventoryDto> fetchInventoryList() {
        return inventoryConverter.convertAll(
                inventoryRepository.findAll()
        );
    }

    @Override
    public void initInventory() {
        storedProcedureProvider.callInitInventory();
    }
}
