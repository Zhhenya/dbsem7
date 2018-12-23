package com.db.campus.property.service.building;

import com.db.campus.property.dto.BuildingDto;

import java.util.List;

public interface BuildingService {

    List<BuildingDto> fetchAll();

    void save(BuildingDto buildingDto);

    void delete(BuildingDto buildingDto);

    BuildingDto fetch(long id);

}
