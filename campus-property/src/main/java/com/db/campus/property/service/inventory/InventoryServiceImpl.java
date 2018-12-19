package com.db.campus.property.service.inventory;

import com.db.campus.property.converter.InventoryConverter;
import com.db.campus.property.dao.InventoryRepository;
import com.db.campus.property.dto.InventoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryConverter inventoryConverter;
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryConverter inventoryConverter, InventoryRepository inventoryRepository) {
        this.inventoryConverter = inventoryConverter;
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryDto> fetchInventoryList() {
        return inventoryConverter.convertAll(
                inventoryRepository.findAll()
        );
    };
}
