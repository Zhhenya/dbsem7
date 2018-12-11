package com.db.campus.property.converter;

import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.entity.*;

import java.util.stream.Collectors;

public class RequestConverter extends CompusPropertyConverter<RequestEntity, RequestDto> {

    @Override
    public RequestDto convert(RequestEntity requestEntity) {
        RequestDto requestDto = new RequestDto();
        requestDto.setId(requestEntity.getPkRequest());
        requestDto.setContent(requestEntity.getReqContent());
        requestDto.setType(defaultConvert(requestEntity.getTypeRequestByPkTypeRequest(), TypeRequestEntity::getTrName));
        requestDto.setState(defaultConvert(requestEntity.getStateRequestByPkStateRequest(),
                                           StateRequestEntity::getSrName));
        requestDto.setUniversityWorker(defaultConvert(requestEntity.getUniversityWorkerByPkUniversityWorker(),
                                                      UniversityWorkerEntity::getUiName));
        requestDto.setEconomicOfficer(defaultConvert(requestEntity.getEconomicOfficerByPkEconomicOfficer(),
                                                     EconomicOfficerEntity::getEoName));
        requestDto.setAccountant(defaultConvert(requestEntity.getAccountantByPkAccountant(),
                                                AccountantEntity::getaName));
        requestDto.setRecords(requestEntity.getRequestRecordsByPkRequest()
                                           .stream()
                                           .map(requestRecordEntity -> requestRecordEntity.getRrNote() + " " +
                                                                       defaultConvert(requestRecordEntity
                                                                                              .getObjectPropertyByPkObjectProperty(),
                                                                                      ObjectPropertyEntity::getOpCaption))
                                           .collect(Collectors.toList()));
        return requestDto;
    }
}
