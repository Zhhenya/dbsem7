package com.db.campus.property.service.request;

import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.dto.RequestRecordDto;
import com.db.campus.property.entity.RequestEntity;
import com.db.campus.property.entity.RequestRecordEntity;

public interface RequestService {

    RequestEntity save(RequestDto requestDto);

    RequestRecordEntity save(RequestRecordDto requestRecordDto, Long requestId);

}
