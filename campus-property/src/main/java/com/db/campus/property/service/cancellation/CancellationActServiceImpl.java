package com.db.campus.property.service.cancellation;

import com.db.campus.property.converter.CancellationActConverter;
import com.db.campus.property.dao.*;
import com.db.campus.property.dto.CancellationActDto;
import com.db.campus.property.dto.CancellationObjectDto;
import com.db.campus.property.dto.CancellationProtocolRecordDto;
import com.db.campus.property.entity.*;
import com.db.campus.property.enums.ObjectState;
import com.db.campus.property.exception.ObjectNotFoundException;
import com.db.campus.property.exception.WorkerNotFoundException;
import com.db.campus.property.service.object.ObjectPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CancellationActServiceImpl implements CancellationActService {

    private final CancellationActRepository cancellationActRepository;
    private final CancellationRecordRepository cancellationRecordRepository;
    private final CancellationActConverter cancellationActConverter;
    private final ObjectPropertyService objectPropertyService;
    private final AccountantRepository accountantRepository;
    private final ObjectPropertyRepository objectPropertyRepository;
    private final StoredProcedureProvider storedProcedureProvider;

    @Autowired
    public CancellationActServiceImpl(CancellationActRepository cancellationActRepository,
                                      CancellationRecordRepository cancellationRecordRepository,
                                      CancellationActConverter cancellationActConverter,
                                      ObjectPropertyService objectPropertyService,
                                      AccountantRepository accountantRepository,
                                      ObjectPropertyRepository objectPropertyRepository,
                                      StoredProcedureProvider storedProcedureProvider) {
        this.cancellationActRepository = cancellationActRepository;
        this.cancellationRecordRepository = cancellationRecordRepository;
        this.cancellationActConverter = cancellationActConverter;
        this.objectPropertyService = objectPropertyService;
        this.accountantRepository = accountantRepository;
        this.objectPropertyRepository = objectPropertyRepository;
        this.storedProcedureProvider = storedProcedureProvider;
    }

    @Transactional
    @Override
    public void create(List<RequestRecordEntity> objects, AccountantEntity accountant) {
        CancellationActEntity act = new CancellationActEntity();
        act.setAccountant(accountant);
        act.setDate(new java.sql.Date(new Date().getTime()));
        addRecords(cancellationActRepository.save(act), objects);
    }

    private void addRecords(CancellationActEntity act, List<RequestRecordEntity> objects) {
        objects.forEach(object -> {
            CancellationRecordEntity record = new CancellationRecordEntity();
            record.setObjectProperty(object.getObjectProperty());
            record.setReason(object.getNote());
            record.setCancellationAct(act);
            cancellationRecordRepository.save(record);
            objectPropertyService.changeState(object.getObjectProperty(), ObjectState.CANCELLED);
        });
    }

    @Override
    public List<CancellationActDto> fetchAll() {
        return cancellationActConverter.convertAll(cancellationActRepository.findAll());
    }

    @Override
    public List<CancellationProtocolRecordDto> fetchProtocol() {
        return storedProcedureProvider.protocol();
    }

    @Transactional
    @Override
    public void create(CancellationObjectDto objectDto) {
        CancellationActEntity actEntity = new CancellationActEntity();
        actEntity.setAccountant(accountantRepository.findById(objectDto.getAccountant().getId())
                .orElseThrow(() -> new WorkerNotFoundException(objectDto.getAccountant().getName())));
        actEntity.setDate(new java.sql.Date(new Date().getTime()));
        addRecord(cancellationActRepository.save(actEntity), objectDto.getReason(),
                objectPropertyRepository.findById(objectDto.getObject().getId())
                        .orElseThrow(() -> new ObjectNotFoundException(objectDto.getObject().getPropertyNumber())));
    }

    private void addRecord(CancellationActEntity act, String reason, ObjectPropertyEntity object) {
        CancellationRecordEntity entity = new CancellationRecordEntity();
        entity.setCancellationAct(act);
        entity.setReason(reason);
        entity.setObjectProperty(object);
        cancellationRecordRepository.save(entity);
    }
}
