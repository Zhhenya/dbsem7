package com.db.campus.property.controller;

import com.db.campus.property.converter.BuildingConverter;
import com.db.campus.property.dao.BuildingRepository;
import com.db.campus.property.dto.BuildingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuildingController {

    private final BuildingRepository buildingRepository;
    private final BuildingConverter buildingConverter;

    @Autowired
    public BuildingController(BuildingRepository buildingRepository, BuildingConverter buildingConverter) {
        this.buildingRepository = buildingRepository;
        this.buildingConverter = buildingConverter;
    }

    @RequestMapping("building/all")
    @ResponseBody
    public List<BuildingDto> fetchAll() {
        return buildingConverter.convertAll(buildingRepository.findAll());
    }

}
