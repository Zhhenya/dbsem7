package com.db.campus.property.service.request;

import com.db.campus.property.dto.ObjectPropertyDto;
import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.dto.RequestRecordDto;
import com.db.campus.property.entity.RequestEntity;
import com.db.campus.property.entity.RequestRecordEntity;
import com.db.campus.property.enums.RequestState;

import java.util.List;

public interface RequestService {

    RequestEntity save(RequestDto requestDto);

    RequestRecordEntity save(RequestRecordDto requestRecordDto, RequestEntity requestEntity);

    List<RequestDto> fetchRequestList();

    List<RequestDto> fetchRequestList(Long universityWorkerId, RequestState requestState);

    List<RequestDto> fetchRequestList(RequestState requestState);

    List<ObjectPropertyDto> fetchObjectList();

    void approve(Long requestId);

}
