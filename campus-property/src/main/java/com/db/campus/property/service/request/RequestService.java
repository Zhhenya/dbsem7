package com.db.campus.property.service.request;

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

    List<RequestDto> fetchWorkerRequestList(Long universityWorkerId, RequestState requestState);

    List<RequestDto> fetchAccountantRequestList(Long accountantId, RequestState requestState);

    List<RequestDto> fetchOfficerRequestList(Long officerId, RequestState requestState);

    List<RequestDto> fetchRequestList(RequestState requestState);

    void approve(Long requestId);

    void startRequestProcessing(Long requestId);

    void markRequestAsReady(Long requestId);

}
