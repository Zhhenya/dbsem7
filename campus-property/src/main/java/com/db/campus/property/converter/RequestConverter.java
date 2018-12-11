package com.db.campus.property.converter;

import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.entity.RequestEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

public class RequestConverter implements Converter<RequestEntity, RequestDto> {

    @Override
    public RequestDto convert(RequestEntity requestEntity) {
        RequestDto requestDto = new RequestDto();
        requestDto.setContent(requestEntity.getReqContent());
        requestDto.setType(requestEntity.getTypeRequestByPkTypeRequest().getTrName());
        requestDto.setState(requestEntity.getStateRequestByPkStateRequest().getSrName());
        requestDto.setUniversityWorker(requestEntity.getUniversityWorkerByPkUniversityWorker().getUiName());
        requestDto.setEconomicOfficer(requestEntity.getEconomicOfficerByPkEconomicOfficer().getEoName());
        requestDto.setAccountant(requestEntity.getAccountantByPkAccountant().getaName());
        requestDto.setRecords(requestEntity.getRequestRecordsByPkRequest()
                                           .stream()
                                           .map(requestRecordEntity -> requestRecordEntity.getRrNote() + " " +
                                                                       requestRecordEntity
                                                                               .getObjectPropertyByPkObjectProperty()
                                                                               .getOpCaption())
                                           .collect(Collectors.toList()));
        return requestDto;
    }
}
