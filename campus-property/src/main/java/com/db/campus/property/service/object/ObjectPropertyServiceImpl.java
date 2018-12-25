package com.db.campus.property.service.object;

import com.db.campus.property.converter.ObjectPropertyConverter;
import com.db.campus.property.dao.*;
import com.db.campus.property.dao.object.property.ObjectPropertyCriteriaRepository;
import com.db.campus.property.dto.ObjectPropertyDto;
import com.db.campus.property.dto.ObjectPropertyFilterDto;
import com.db.campus.property.entity.ObjectPropertyEntity;
import com.db.campus.property.enums.ObjectState;
import com.db.campus.property.service.RandomProviderService;
import com.db.campus.property.service.officer.OfficerServiceImpl;
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
    private final RandomProviderService randomProviderService;
    private final AccountantRepository accountantRepository;
    private final EconomicOfficerRepository economicOfficerRepository;
    private final RoomRepository roomRepository;
    private final StateRepository stateRepository;

    @Autowired
    public ObjectPropertyServiceImpl(ObjectPropertyRepository objectPropertyRepository,
                                     ObjectPropertyConverter objectPropertyConverter,
                                     ObjectPropertyCriteriaRepository objectPropertyCriteriaRepository,
                                     RandomProviderService randomProviderService,
                                     AccountantRepository accountantRepository,
                                     EconomicOfficerRepository economicOfficerRepository,
                                     RoomRepository roomRepository,
                                     StateRepository stateRepository) {
        this.objectPropertyRepository = objectPropertyRepository;
        this.objectPropertyConverter = objectPropertyConverter;
        this.objectPropertyCriteriaRepository = objectPropertyCriteriaRepository;
        this.randomProviderService = randomProviderService;
        this.accountantRepository = accountantRepository;
        this.economicOfficerRepository = economicOfficerRepository;
        this.roomRepository = roomRepository;
        this.stateRepository = stateRepository;
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
    public ObjectPropertyEntity save(ObjectPropertyDto objectPropertyDto) {
        ObjectPropertyEntity objectPropertyEntity = new ObjectPropertyEntity();
        objectPropertyEntity.setPropertyNumber(objectPropertyDto.getPropertyNumber());
        objectPropertyEntity.setCaption(objectPropertyDto.getCaption());
        objectPropertyEntity.setDate(Date.valueOf(objectPropertyDto.getDate()));
        objectPropertyEntity.setCost(BigDecimal.valueOf(
                Long.parseLong(objectPropertyDto.getCost())));
        objectPropertyEntity.setAccountant(randomProviderService.retrieveRandom(accountantRepository.findAll()));
        objectPropertyEntity.setEconomicOfficer(randomProviderService.retrieveRandom(economicOfficerRepository.findAll()));
        objectPropertyEntity.setMaker(objectPropertyDto.getMaker());
        objectPropertyEntity.setRoom(randomProviderService.retrieveRandom(roomRepository.findAll()));
        objectPropertyEntity.setState(randomProviderService.retrieveRandom(stateRepository.findAll()));
        return objectPropertyRepository.save(objectPropertyEntity);
    }

    @Override
    public List<ObjectPropertyDto> fetchFiltered(ObjectPropertyFilterDto objectPropertyFilterDto) {
        return objectPropertyConverter.convertAll(
                objectPropertyCriteriaRepository.findFiltered(objectPropertyFilterDto));
    }


}
