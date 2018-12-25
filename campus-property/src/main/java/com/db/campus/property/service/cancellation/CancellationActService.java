package com.db.campus.property.service.cancellation;

import com.db.campus.property.entity.AccountantEntity;
import com.db.campus.property.entity.RequestRecordEntity;

import java.util.List;

public interface CancellationActService {

    void create(List<RequestRecordEntity> objects, AccountantEntity accountant);

}
