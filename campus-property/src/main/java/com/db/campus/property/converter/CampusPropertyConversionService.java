package com.db.campus.property.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public abstract class CampusPropertyConversionService {

    private final ConversionService conversionService;

    @Autowired
    public CampusPropertyConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public <T> List<T> convertAll(Iterable objList, Class<T> aClass) {
        List<T> convertedObjList = new ArrayList<>();
        objList.forEach(o -> convertedObjList.add(conversionService.convert(o, aClass)));
        return convertedObjList;
    }

}
