package com.db.campus.property.service.officer;

import com.db.campus.property.converter.EconomicOfficerConverter;
import com.db.campus.property.dao.EconomicOfficerRepository;
import com.db.campus.property.dto.EconomicOfficerDto;
import com.db.campus.property.entity.EconomicOfficerEntity;
import com.db.campus.property.exception.WorkerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficerServiceImpl implements OfficerService {

    private final EconomicOfficerRepository economicOfficerRepository;
    private final EconomicOfficerConverter economicOfficerConverter;

    @Autowired
    public OfficerServiceImpl(EconomicOfficerRepository economicOfficerRepository,
                              EconomicOfficerConverter economicOfficerConverter) {
        this.economicOfficerRepository = economicOfficerRepository;
        this.economicOfficerConverter = economicOfficerConverter;
    }

    @Override
    public List<EconomicOfficerDto> findAll() {
        return economicOfficerConverter.convertAll(economicOfficerRepository.findAll());
    }

    @Override
    public void save(EconomicOfficerDto officerDto) {
        EconomicOfficerEntity officerEntity = economicOfficerRepository.findById(officerDto.getId())
                                                                      .orElseThrow(() -> new WorkerNotFoundException(
                                                                              officerDto.getName()));
        officerEntity.setName(officerDto.getName());
        economicOfficerRepository.save(officerEntity);
    }

    @Override
    public EconomicOfficerDto fetch(Long id) {
        return economicOfficerConverter.convert(economicOfficerRepository.findById(id)
                                                                         .orElseThrow(() -> new WorkerNotFoundException(id.toString())));
    }
}
