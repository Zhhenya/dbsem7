package com.db.campus.property.service.builder;

import com.db.campus.property.converter.BuildingConverter;
import com.db.campus.property.dao.BuildingRepository;
import com.db.campus.property.dto.BuildingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingAddressServiceImpl implements BuildingAddressService {
    private BuildingRepository buildingRepository;
    private BuildingConverter buildingConverter;

    @Autowired
    public BuildingAddressServiceImpl(BuildingRepository buildingRepository,
                                      BuildingConverter buildingConverter){
        this.buildingRepository = buildingRepository;
        this.buildingConverter = buildingConverter;
    }
    @Override
    public List<BuildingDto> fetchBuildingAddress() {
        return buildingConverter.convertAll(buildingRepository.findAll());
    }
}