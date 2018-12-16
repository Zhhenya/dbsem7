package com.db.campus.property.converter;

import com.db.campus.property.dto.RequestRecordDto;
import com.db.campus.property.entity.RequestRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestRecordConverter extends CampusPropertyConverter<RequestRecordEntity, RequestRecordDto> {

    private final ObjectPropertyConverter objectPropertyConverter;

    @Autowired
    public RequestRecordConverter(ObjectPropertyConverter objectPropertyConverter) {
        this.objectPropertyConverter = objectPropertyConverter;
    }

    @Override
    public RequestRecordDto convert(RequestRecordEntity value) {
        RequestRecordDto recordDto = new RequestRecordDto();
        recordDto.setId(value.getId());
        recordDto.setNote(value.getNote());
        recordDto.setObjectProperty(defaultConvert(value.getObjectProperty(),
                                                   objectPropertyConverter::convert,
                                                   null));
        return recordDto;
    }
}
