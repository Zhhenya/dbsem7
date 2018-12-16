package com.db.campus.property.service.request;

import com.db.campus.property.converter.RequestConverter;
import com.db.campus.property.dao.*;
import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.dto.RequestRecordDto;
import com.db.campus.property.entity.RequestEntity;
import com.db.campus.property.entity.RequestRecordEntity;
import com.db.campus.property.enums.RequestState;
import com.db.campus.property.service.RandomProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestConverter requestConverter;
    private final RequestRepository requestRepository;
    private final TypeRequestRepository typeRequestRepository;
    private final StateRequestRepository stateRequestRepository;
    private final RequestRecordRepository requestRecordRepository;
    private final UniversityWorkerRepository universityWorkerRepository;
    private final EconomicOfficerRepository economicOfficerRepository;
    private final AccountantRepository accountantRepository;
    private final RandomProviderService randomProviderService;
    private final ObjectPropertyRepository objectPropertyRepository;

    @Autowired
    public RequestServiceImpl(RequestConverter requestConverter,
                              RequestRepository requestRepository,
                              TypeRequestRepository typeRequestRepository,
                              StateRequestRepository stateRequestRepository,
                              RequestRecordRepository requestRecordRepository,
                              UniversityWorkerRepository universityWorkerRepository,
                              EconomicOfficerRepository economicOfficerRepository,
                              AccountantRepository accountantRepository,
                              RandomProviderService randomProviderService,
                              ObjectPropertyRepository objectPropertyRepository) {
        this.requestConverter = requestConverter;
        this.requestRepository = requestRepository;
        this.typeRequestRepository = typeRequestRepository;
        this.stateRequestRepository = stateRequestRepository;
        this.requestRecordRepository = requestRecordRepository;
        this.universityWorkerRepository = universityWorkerRepository;
        this.economicOfficerRepository = economicOfficerRepository;
        this.accountantRepository = accountantRepository;
        this.randomProviderService = randomProviderService;
        this.objectPropertyRepository = objectPropertyRepository;
    }

    @Transactional
    @Override
    public RequestRecordEntity save(RequestRecordDto requestRecordDto, RequestEntity requestEntity) {
        RequestRecordEntity requestRecordEntity = new RequestRecordEntity();
        requestRecordEntity.setNote(requestRecordDto.getNote());
        String propertyNumber = requestRecordDto.getObjectProperty().getPropertyNumber();
        if (!propertyNumber.isEmpty()) {
            requestRecordEntity.setObjectProperty(objectPropertyRepository.findByPropertyNumber(propertyNumber));
        }
        requestRecordEntity.setRequest(requestEntity);
        return requestRecordRepository.saveAndFlush(requestRecordEntity);
    }

    @Transactional
    @Override
    public RequestEntity save(RequestDto requestDto) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setContent(requestDto.getContent());
        requestEntity.setTypeRequest(typeRequestRepository.findByName(requestDto.getType()));
        requestEntity.setStateRequest(stateRequestRepository.findByName(RequestState.WAITING.getDisplayName()));
        requestEntity.setUniversityWorker(universityWorkerRepository.findById(requestDto.getUniversityWorker().getId()).get());
        requestEntity.setAccountant(randomProviderService.retrieveRandom(accountantRepository.findAll()));
        requestEntity.setEconomicOfficer(randomProviderService.retrieveRandom(economicOfficerRepository.findAll()));
        RequestEntity savedEntity = requestRepository.save(requestEntity);
        requestDto.getRequestRecordList().forEach(requestRecordDto -> save(requestRecordDto, savedEntity));
        return savedEntity;
    }

    @Override
    public List<RequestDto> fetchRequestList() {
        return requestConverter.convertAll(requestRepository.findAll());
    }
}