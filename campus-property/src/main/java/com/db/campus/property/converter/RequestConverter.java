package com.db.campus.property.converter;

import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.entity.RequestEntity;
import com.db.campus.property.entity.StateRequestEntity;
import com.db.campus.property.entity.TypeRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestConverter extends CampusPropertyConverter<RequestEntity, RequestDto> {

    private final UniversityWorkerConverter universityWorkerConverter;
    private final EconomicOfficerConverter economicOfficerConverter;
    private final AccountantConverter accountantConverter;

    @Autowired
    public RequestConverter(UniversityWorkerConverter universityWorkerConverter,
                            EconomicOfficerConverter economicOfficerConverter,
                            AccountantConverter accountantConverter) {
        this.universityWorkerConverter = universityWorkerConverter;
        this.economicOfficerConverter = economicOfficerConverter;
        this.accountantConverter = accountantConverter;
    }

    @Override
    public RequestDto convert(RequestEntity requestEntity) {
        RequestDto requestDto = new RequestDto();
        requestDto.setId(requestEntity.getId());
        requestDto.setContent(requestEntity.getContent());
        requestDto.setType(defaultConvert(requestEntity.getTypeRequest(), TypeRequestEntity::getName));
        requestDto.setState(defaultConvert(requestEntity.getStateRequest(),
                                           StateRequestEntity::getName));
        requestDto.setUniversityWorker(defaultConvert(requestEntity.getUniversityWorker(),
                                                      universityWorkerConverter::convert,
                                                      null));
        requestDto.setEconomicOfficer(defaultConvert(requestEntity.getEconomicOfficer(),
                                                     economicOfficerConverter::convert,
                                                     null));
        requestDto.setAccountant(defaultConvert(requestEntity.getAccountant(),
                                                accountantConverter::convert,
                                                null));
        return requestDto;
    }
}
