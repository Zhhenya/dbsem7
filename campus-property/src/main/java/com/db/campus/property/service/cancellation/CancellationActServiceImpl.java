package com.db.campus.property.service.cancellation;

import com.db.campus.property.dao.CancellationActRepository;
import com.db.campus.property.dao.CancellationRecordRepository;
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
    private final ObjectPropertyService objectPropertyService;

    @Autowired
    public CancellationActServiceImpl(CancellationActRepository cancellationActRepository,
                                      CancellationRecordRepository cancellationRecordRepository,
                                      ObjectPropertyService objectPropertyService) {
        this.cancellationActRepository = cancellationActRepository;
        this.cancellationRecordRepository = cancellationRecordRepository;
        this.objectPropertyService = objectPropertyService;
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

}
