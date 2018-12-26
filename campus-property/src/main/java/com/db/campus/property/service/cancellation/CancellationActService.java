package com.db.campus.property.service.cancellation;

import com.db.campus.property.dto.CancellationActDto;
import com.db.campus.property.dto.CancellationObjectDto;
import com.db.campus.property.dto.CancellationProtocolRecordDto;
import com.db.campus.property.dto.ObjectPropertyDto;
import com.db.campus.property.entity.AccountantEntity;
import com.db.campus.property.entity.RequestRecordEntity;

import java.util.List;

public interface CancellationActService {

    List<CancellationActDto> fetchAll();

    void create(List<RequestRecordEntity> objects, AccountantEntity accountant);

    List<CancellationProtocolRecordDto> fetchProtocol();

    void create(CancellationObjectDto objectDto);

}
