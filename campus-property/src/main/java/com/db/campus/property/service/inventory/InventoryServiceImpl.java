package com.db.campus.property.service.inventory;

import com.db.campus.property.converter.InventoryConverter;
import com.db.campus.property.dao.InventoryRepository;
import com.db.campus.property.dao.StoredProcedureProvider;
import com.db.campus.property.dto.InventoryDto;
import com.db.campus.property.entity.InventoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional
    @Override
    public void initInventory() {
        storedProcedureProvider.callInitInventory();
    }

    @Transactional
    @Override
    public Long fetchLastId() {
        List<InventoryEntity> list = new ArrayList<>(inventoryRepository.findAll());
        return list.get(list.size() - 1).getId();
    }
}
