package com.db.campus.property.service.building;

import com.db.campus.property.converter.BuildingConverter;
import com.db.campus.property.dao.BuildingRepository;
import com.db.campus.property.dto.BuildingDto;
import com.db.campus.property.entity.BuildingEntity;
import com.db.campus.property.exception.BuildingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;
    private final BuildingConverter buildingConverter;

    @Autowired
    public BuildingServiceImpl(BuildingRepository buildingRepository, BuildingConverter buildingConverter) {
        this.buildingRepository = buildingRepository;
        this.buildingConverter = buildingConverter;
    }

    @Override
    public List<BuildingDto> fetchAll() {
        return buildingConverter.convertAll(buildingRepository.findAll());
    }

    @Override
    public void save(BuildingDto buildingDto) {
        BuildingEntity buildingEntity = new BuildingEntity();
        if (buildingDto.getId() != null) {
            buildingEntity = buildingRepository.findById(buildingDto.getId())
                                               .orElseThrow(() -> new BuildingNotFoundException(buildingDto.getAddress()));
        }
        buildingEntity.setAddress(buildingDto.getAddress());
        buildingRepository.save(buildingEntity);
    }

    @Override
    public void delete(BuildingDto buildingDto) {
        buildingRepository.deleteById(buildingDto.getId());
    }
}
