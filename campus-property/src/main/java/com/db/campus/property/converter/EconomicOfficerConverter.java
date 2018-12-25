package com.db.campus.property.converter;

import com.db.campus.property.dto.EconomicOfficerDto;
import com.db.campus.property.entity.EconomicOfficerEntity;
import org.springframework.stereotype.Service;

@Service
public class EconomicOfficerConverter extends CampusPropertyConverter<EconomicOfficerEntity, EconomicOfficerDto> {

    @Override
    public EconomicOfficerDto convert(EconomicOfficerEntity economicOfficerEntity) {
        EconomicOfficerDto workerDto = new EconomicOfficerDto();
        workerDto.setId(economicOfficerEntity.getId());
        workerDto.setName(economicOfficerEntity.getName());
        workerDto.setEmail(economicOfficerEntity.getEmail());
        return workerDto;
    }
}
