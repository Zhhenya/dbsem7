package com.db.campus.property.service.cancellation;

import com.db.campus.property.converter.CancellationActConverter;
import com.db.campus.property.dao.CancellationActRepository;
import com.db.campus.property.dao.CancellationRecordRepository;
import com.db.campus.property.dao.StoredProcedureProvider;
import com.db.campus.property.dto.CancellationActDto;
import com.db.campus.property.dto.CancellationProtocolRecordDto;
import com.db.campus.property.entity.AccountantEntity;
import com.db.campus.property.entity.CancellationActEntity;
import com.db.campus.property.entity.CancellationRecordEntity;
import com.db.campus.property.entity.RequestRecordEntity;
import com.db.campus.property.enums.ObjectState;
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
    private final StoredProcedureProvider storedProcedureProvider;

    @Autowired
    public CancellationActServiceImpl(CancellationActRepository cancellationActRepository,
                                      CancellationRecordRepository cancellationRecordRepository,
                                      CancellationActConverter cancellationActConverter,
                                      ObjectPropertyService objectPropertyService,
                                      StoredProcedureProvider storedProcedureProvider) {
        this.cancellationActRepository = cancellationActRepository;
        this.cancellationRecordRepository = cancellationRecordRepository;
        this.cancellationActConverter = cancellationActConverter;
        this.objectPropertyService = objectPropertyService;
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
}
