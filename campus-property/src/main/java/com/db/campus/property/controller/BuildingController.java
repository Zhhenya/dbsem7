package com.db.campus.property.controller;

import com.db.campus.property.dto.BuildingDto;
import com.db.campus.property.service.building.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuildingController {

    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @RequestMapping("building/all")
    @ResponseBody
    public List<BuildingDto> fetchAll() {
        return buildingService.fetchAll();
    }

    @RequestMapping("building/{id}")
    @ResponseBody
    public BuildingDto fetch(@PathVariable("id") long id) {
        return buildingService.fetch(id);
    }

    @RequestMapping(value = "building/save", method = RequestMethod.POST)
    @ResponseBody
    public Boolean fetchAll(@RequestBody BuildingDto buildingDto) {
        buildingService.save(buildingDto);
        return true;
    }

    @RequestMapping(value = "building/delete", method = RequestMethod.POST)
    @ResponseBody
    public Boolean delete(@RequestBody BuildingDto buildingDto) {
        buildingService.delete(buildingDto);
        return true;
    }

}
