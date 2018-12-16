package com.db.campus.property.service.object;

import com.db.campus.property.converter.ObjectPropertyConverter;
import com.db.campus.property.dao.ObjectPropertyRepository;
import com.db.campus.property.dto.ObjectPropertyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ObjectPropertyServiceImpl implements ObjectPropertyService {

    private final ObjectPropertyRepository objectPropertyRepository;
    private final ObjectPropertyConverter objectPropertyConverter;

    @Autowired
    public ObjectPropertyServiceImpl(ObjectPropertyRepository objectPropertyRepository,
                                     ObjectPropertyConverter objectPropertyConverter) {
        this.objectPropertyRepository = objectPropertyRepository;
        this.objectPropertyConverter = objectPropertyConverter;
    }

    @Override
    public List<ObjectPropertyDto> fetchAll() {
        return objectPropertyConverter.convertAll(objectPropertyRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public List<ObjectPropertyDto> fetchObjectList() {
        return objectPropertyConverter.convertAll(objectPropertyRepository.findAll());
    }
}
