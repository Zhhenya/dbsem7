package com.db.campus.property.converter;

import com.db.campus.property.entity.TypeRequestEntity;
import org.springframework.stereotype.Service;

@Service
public class RequestTypeConverter extends CampusPropertyConverter<TypeRequestEntity, String> {

    @Override
    public String convert(TypeRequestEntity value) {
        return value.getName();
    }
}
