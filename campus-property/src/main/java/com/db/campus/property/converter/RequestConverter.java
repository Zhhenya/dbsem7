package com.db.campus.property.converter;

import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.entity.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RequestConverter extends CampusPropertyConverter<RequestEntity, RequestDto> {

    @Override
    public RequestDto convert(RequestEntity requestEntity) {
        RequestDto requestDto = new RequestDto();
        requestDto.setId(requestEntity.getId());
        requestDto.setContent(requestEntity.getContent());
        requestDto.setType(defaultConvert(requestEntity.getTypeRequest(), TypeRequestEntity::getName));
        requestDto.setState(defaultConvert(requestEntity.getStateRequest(),
                                           StateRequestEntity::getName));
        requestDto.setUniversityWorker(defaultConvert(requestEntity.getUniversityWorker(),
                                                      UniversityWorkerEntity::getName));
        requestDto.setEconomicOfficer(defaultConvert(requestEntity.getEconomicOfficer(),
                                                     EconomicOfficerEntity::getName));
        requestDto.setAccountant(defaultConvert(requestEntity.getAccountant(),
                                                AccountantEntity::getName));
        requestDto.setRecords(requestEntity.getRequestRecords()
                                           .stream()
                                           .map(requestRecordEntity -> requestRecordEntity.getNote() + " " +
                                                                       defaultConvert(requestRecordEntity
                                                                                              .getObjectProperty(),
                                                                                      ObjectPropertyEntity::getCaption))
                                           .collect(Collectors.toList()));
        return requestDto;
    }
}
