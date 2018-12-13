package com.db.campus.property.service.request;

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

@Service
public class RequestServiceImpl implements RequestService {

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
    public RequestServiceImpl(RequestRepository requestRepository,
                              TypeRequestRepository typeRequestRepository,
                              StateRequestRepository stateRequestRepository,
                              RequestRecordRepository requestRecordRepository,
                              UniversityWorkerRepository universityWorkerRepository,
                              EconomicOfficerRepository economicOfficerRepository,
                              AccountantRepository accountantRepository,
                              RandomProviderService randomProviderService,
                              ObjectPropertyRepository objectPropertyRepository) {
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
    public RequestRecordEntity save(RequestRecordDto requestRecordDto, Long requestId) {
        RequestRecordEntity recordEntity = new RequestRecordEntity();
        recordEntity.setNote(requestRecordDto.getNote());
        String propertyNumber = requestRecordDto.getObjectPropertyDto().getPropertyNumber();
        if (propertyNumber != null) {
            recordEntity.setObjectProperty(objectPropertyRepository.findByPropertyNumber(propertyNumber));
        }
        recordEntity.setRequest(requestRepository.findById(requestId).get());
        return requestRecordRepository.saveAndFlush(recordEntity);
    }

    @Transactional
    @Override
    public RequestEntity save(RequestDto requestDto) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setContent(requestDto.getContent());
        requestEntity.setTypeRequest(typeRequestRepository.findByName(requestDto.getType()));
        requestEntity.setStateRequest(stateRequestRepository.findByName(RequestState.WAITING.name()));
        requestEntity.setUniversityWorker(universityWorkerRepository.findById(requestDto.getId()).get());
        requestEntity.setAccountant(randomProviderService.retrieveRandom(accountantRepository.findAll()));
        requestEntity.setEconomicOfficer(randomProviderService.retrieveRandom(economicOfficerRepository.findAll()));
        RequestEntity savedEntity = requestRepository.saveAndFlush(requestEntity);
        requestDto.getRequestRecordDtoList().forEach(requestRecordDto -> save(requestRecordDto, savedEntity.getId()));
        return savedEntity;
    }
}
