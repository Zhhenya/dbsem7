package com.db.campus.property.dao;

import com.db.campus.property.dto.CancellationProtocolRecordDto;
import com.db.campus.property.service.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoredProcedureProviderImpl implements StoredProcedureProvider {

    private final DateFormatter dateFormatter;
    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    public StoredProcedureProviderImpl(DateFormatter dateFormatter) {this.dateFormatter = dateFormatter;}

    @Override
    public void callInitInventory() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("initInventarisation");
        query.execute();
    }

    @Override
    public List<CancellationProtocolRecordDto> protocol() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("protocol");
        query.execute();
        List resultList = query.getResultList();
        List<CancellationProtocolRecordDto> records = new ArrayList<>();
        for (Object o : resultList) {
            Object[] objects = (Object[])o;
            CancellationProtocolRecordDto recordDto = new CancellationProtocolRecordDto();
            recordDto.setDate(dateFormatter.format(((Date) objects[0])));
            recordDto.setObject(objects[1].toString());
            recordDto.setReason(objects[2].toString());
            recordDto.setOfficerName(objects[3].toString());
            records.add(recordDto);
        }
        return records;
    }
}
