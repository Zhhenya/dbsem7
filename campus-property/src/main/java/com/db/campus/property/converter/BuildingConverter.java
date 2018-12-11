package com.db.campus.property.converter;

import com.db.campus.property.dto.BuildingDto;
import com.db.campus.property.entity.BuildingEntity;
import org.springframework.stereotype.Service;

@Service
public class BuildingConverter extends CampusPropertyConverter<BuildingEntity, BuildingDto> {

    @Override
    public BuildingDto convert(BuildingEntity buildingEntity) {
        BuildingDto buildingDto = new BuildingDto();
        buildingDto.setId(buildingEntity.getId());
        buildingDto.setAddress(buildingEntity.getAddress());
        return buildingDto;
    }
}
