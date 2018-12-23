package com.db.campus.property.converter;

import com.db.campus.property.dto.ResultInventoryDto;
import com.db.campus.property.entity.ResultInventoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultInventoryConverter extends CampusPropertyConverter<ResultInventoryEntity, ResultInventoryDto> {

    private final ObjectPropertyConverter objectPropertyConverter;
    private final InventoryConverter inventoryConverter;

    @Autowired
    public ResultInventoryConverter(ObjectPropertyConverter objectPropertyConverter, InventoryConverter inventoryConverter) {
        this.objectPropertyConverter = objectPropertyConverter;
        this.inventoryConverter = inventoryConverter;
    }

    @Override
    public ResultInventoryDto convert(ResultInventoryEntity resultInventoryEntity) {
        ResultInventoryDto resultInventoryDto = new ResultInventoryDto();

        resultInventoryDto.setId(resultInventoryEntity.getId());
        resultInventoryDto.setResult(resultInventoryEntity.getResult());
        resultInventoryDto.setObjectProperty(
                defaultConvert(
                        resultInventoryEntity.getObjectProperty(),
                        objectPropertyConverter::convert,
                        null
                )
        );
        resultInventoryDto.setInventory(
                defaultConvert(
                        resultInventoryEntity.getInventory(),
                        inventoryConverter::convert,
                        null
                )
        );

        return resultInventoryDto;
    }
}
