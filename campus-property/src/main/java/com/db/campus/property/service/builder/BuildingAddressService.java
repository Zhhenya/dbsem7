package com.db.campus.property.service.builder;

import com.db.campus.property.dto.BuildingDto;

import java.util.List;

public interface BuildingAddressService {
    List<BuildingDto> fetchBuildingAddress();
}
