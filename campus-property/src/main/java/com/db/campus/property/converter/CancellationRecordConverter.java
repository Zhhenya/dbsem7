package com.db.campus.property.converter;

import com.db.campus.property.dto.CancellationRecordDto;
import com.db.campus.property.entity.CancellationRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancellationRecordConverter extends CampusPropertyConverter<CancellationRecordEntity, CancellationRecordDto> {

    private final ObjectPropertyConverter objectPropertyConverter;

    @Autowired
    public CancellationRecordConverter(ObjectPropertyConverter objectPropertyConverter) {
        this.objectPropertyConverter = objectPropertyConverter;
    }

    @Override
    public CancellationRecordDto convert(CancellationRecordEntity value) {
        CancellationRecordDto dto = new CancellationRecordDto();
        dto.setId(value.getId());
        dto.setObject(objectPropertyConverter.convert(value.getObjectProperty()));
        dto.setReason(value.getReason());
        return dto;
    }
}
