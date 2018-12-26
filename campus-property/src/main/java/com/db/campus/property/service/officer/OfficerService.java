package com.db.campus.property.service.officer;

import com.db.campus.property.dto.EconomicOfficerDto;

import java.util.List;

public interface OfficerService {

    List<EconomicOfficerDto> findAll();

    void save(EconomicOfficerDto workerDto);

    EconomicOfficerDto fetch(Long id);

}
