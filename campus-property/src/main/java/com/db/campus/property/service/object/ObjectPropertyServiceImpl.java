package com.db.campus.property.service.object;

import com.db.campus.property.converter.ObjectPropertyConverter;
import com.db.campus.property.dao.*;
import com.db.campus.property.dao.object.property.ObjectPropertyCriteriaRepository;
import com.db.campus.property.dto.ObjectPropertyDto;
import com.db.campus.property.dto.ObjectPropertyFilterDto;
import com.db.campus.property.entity.ObjectPropertyEntity;
import com.db.campus.property.enums.ObjectState;
import com.db.campus.property.exception.ObjectNotFoundException;
import com.db.campus.property.exception.RoomNotFoundException;
import com.db.campus.property.exception.WorkerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectPropertyServiceImpl implements ObjectPropertyService {


    private final ObjectPropertyRepository objectPropertyRepository;
    private final ObjectPropertyConverter objectPropertyConverter;
    private final ObjectPropertyCriteriaRepository objectPropertyCriteriaRepository;
    private final AccountantRepository accountantRepository;
    private final EconomicOfficerRepository economicOfficerRepository;
    private final RoomRepository roomRepository;
    private final StateRepository stateRepository;

    @Autowired
    public ObjectPropertyServiceImpl(ObjectPropertyRepository objectPropertyRepository,
                                     ObjectPropertyConverter objectPropertyConverter,
                                     ObjectPropertyCriteriaRepository objectPropertyCriteriaRepository,
                                     AccountantRepository accountantRepository,
                                     EconomicOfficerRepository economicOfficerRepository,
                                     RoomRepository roomRepository,
                                     StateRepository stateRepository) {
        this.objectPropertyRepository = objectPropertyRepository;
        this.objectPropertyConverter = objectPropertyConverter;
        this.objectPropertyCriteriaRepository = objectPropertyCriteriaRepository;
        this.accountantRepository = accountantRepository;
        this.economicOfficerRepository = economicOfficerRepository;
        this.roomRepository = roomRepository;
        this.stateRepository = stateRepository;
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    @Override
    public List<String> fetchMakers() {
        return objectPropertyRepository.findDistinctMakers();
    }

    @Transactional
    @Override
    public ObjectPropertyEntity save(ObjectPropertyDto objectPropertyDto) {
        ObjectPropertyEntity objectPropertyEntity = new ObjectPropertyEntity();
        if (objectPropertyDto.getId() != null) {
            objectPropertyEntity = objectPropertyRepository
                    .findById(objectPropertyDto.getId())
                    .orElseThrow(() -> new ObjectNotFoundException(objectPropertyDto.getPropertyNumber()));
        }
        objectPropertyEntity.setPropertyNumber(objectPropertyDto.getPropertyNumber());
        objectPropertyEntity.setCaption(objectPropertyDto.getCaption());
        objectPropertyEntity.setDate(Date.valueOf(objectPropertyDto.getDate()));
        objectPropertyEntity.setCost(BigDecimal.valueOf(Double.parseDouble(objectPropertyDto.getCost())));
        objectPropertyEntity.setAccountant(
                accountantRepository
                        .findById(objectPropertyDto.getAccountant().getId())
                        .orElseThrow(() -> new WorkerNotFoundException(objectPropertyDto.getAccountant().getName())));
        objectPropertyEntity.setEconomicOfficer(
                economicOfficerRepository
                        .findById(objectPropertyDto.getEconomicOfficer().getId())
                        .orElseThrow(() -> new WorkerNotFoundException(objectPropertyDto.getEconomicOfficer().getName())));
        objectPropertyEntity.setMaker(objectPropertyDto.getMaker());
        objectPropertyEntity.setRoom(roomRepository
                                             .findById(objectPropertyDto.getRoom().getId())
                                             .orElseThrow(() -> new RoomNotFoundException(objectPropertyDto.getRoom().getId())));
        objectPropertyEntity.setState(stateRepository.findByName(objectPropertyDto.getState()));
        return objectPropertyRepository.save(objectPropertyEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ObjectPropertyDto> fetchFiltered(ObjectPropertyFilterDto objectPropertyFilterDto) {
        return objectPropertyConverter.convertAll(
                objectPropertyCriteriaRepository.findFiltered(objectPropertyFilterDto));
    }

    @Transactional(readOnly = true)
    @Override
    public ObjectPropertyDto fetch(Long objectId) {
        return objectPropertyConverter.convert(
                objectPropertyRepository.findById(objectId)
                                        .orElseThrow(() -> new ObjectNotFoundException(objectId.toString())));
    }

    @Override
    public void changeState(ObjectPropertyEntity entity, ObjectState state) {
        entity.setState(stateRepository.findByName(state.getDisplayName()));
        objectPropertyRepository.save(entity);
    }
}
