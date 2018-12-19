package com.db.campus.property.converter;

import com.db.campus.property.dto.InventoryDto;
import com.db.campus.property.entity.InventoryEntity;
import org.springframework.stereotype.Service;

@Service
public class InventoryConverter extends CampusPropertyConverter<InventoryEntity, InventoryDto> {

    @Override
    public InventoryDto convert(InventoryEntity inventoryEntity) {
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setId(inventoryEntity.getId());
        inventoryDto.setDate(inventoryEntity.getDate());
        return inventoryDto;
    }
}
