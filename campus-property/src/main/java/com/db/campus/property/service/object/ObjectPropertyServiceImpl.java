package com.db.campus.property.service.object;

import com.db.campus.property.converter.ObjectPropertyConverter;
import com.db.campus.property.dao.ObjectPropertyRepository;
import com.db.campus.property.dao.object.property.ObjectPropertyCriteriaRepository;
import com.db.campus.property.dto.ObjectPropertyDto;
import com.db.campus.property.dto.ObjectPropertyFilterDto;
import com.db.campus.property.enums.ObjectState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectPropertyServiceImpl implements ObjectPropertyService {


    private final ObjectPropertyRepository objectPropertyRepository;
    private final ObjectPropertyConverter objectPropertyConverter;
    private final ObjectPropertyCriteriaRepository objectPropertyCriteriaRepository;

    @Autowired
    public ObjectPropertyServiceImpl(ObjectPropertyRepository objectPropertyRepository,
                                     ObjectPropertyConverter objectPropertyConverter,
                                     ObjectPropertyCriteriaRepository objectPropertyCriteriaRepository) {
        this.objectPropertyRepository = objectPropertyRepository;
        this.objectPropertyConverter = objectPropertyConverter;
        this.objectPropertyCriteriaRepository = objectPropertyCriteriaRepository;
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

    @Transactional(readOnly = true)
    @Override
    public List<String> fetchStates() {
        return Arrays.stream(ObjectState.values())
                     .map(ObjectState::getDisplayName)
                     .collect(Collectors.toList());
    }

    @Override
    public List<String> fetchMakers() {
        return objectPropertyRepository.findDistinctMakers();
    }

    @Override
    public List<ObjectPropertyDto> fetchFiltered(ObjectPropertyFilterDto objectPropertyFilterDto) {
        return objectPropertyConverter.convertAll(
                objectPropertyCriteriaRepository.findFiltered(objectPropertyFilterDto));
    }
}
