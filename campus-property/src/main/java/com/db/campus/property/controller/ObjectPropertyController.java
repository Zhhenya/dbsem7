package com.db.campus.property.controller;

import com.db.campus.property.dto.*;
import com.db.campus.property.service.builder.BuildingAddressService;
import com.db.campus.property.service.object.ObjectPropertyService;
import com.db.campus.property.service.officer.OfficerService;
import com.db.campus.property.service.room.RoomNumberService;
import com.db.campus.property.service.state.StateObjectPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObjectPropertyController {

    private final ObjectPropertyService objectPropertyService;
    private final RoomNumberService roomNumberService;
    private final BuildingAddressService buildingAddressService;
    private final StateObjectPropertyService stateObjectPropertyService;
    private final OfficerService officerService;


    @Autowired
    public ObjectPropertyController(ObjectPropertyService objectPropertyService,
                                    RoomNumberService roomNumberService,
                                    BuildingAddressService buildingAddressService,
                                    StateObjectPropertyService stateObjectPropertyService,
                                    OfficerService officerService) {
        this.objectPropertyService = objectPropertyService;
        this.roomNumberService = roomNumberService;
        this.buildingAddressService = buildingAddressService;
        this.stateObjectPropertyService = stateObjectPropertyService;
        this.officerService = officerService;
    }

    @RequestMapping("/object/list")
    @ResponseBody
    public List<ObjectPropertyDto> fetchAll() {
        return objectPropertyService.fetchAll();
    }

    @RequestMapping("/inventory/room")
    @ResponseBody
    public List<RoomDto> getRequestRoomList() {
        return roomNumberService.fetchRoomNumberList();
    }

    @RequestMapping("object/building")
    @ResponseBody
    public List<BuildingDto> getBuildingAddressList(){
        return buildingAddressService.fetchBuildingAddress();
    }

    @RequestMapping("object/state")
    @ResponseBody
    public List<StateDto> getStateObjectProperty(){
        return stateObjectPropertyService.fetchStateObjectProperty();
    }

    @RequestMapping("/objectProperty")
    @ResponseBody
    public List<ObjectPropertyDto> getObjectPropertyList() {
        return objectPropertyService.fetchObjectList();
    }

    @RequestMapping("object/economicOfficers")
    @ResponseBody
    public List<EconomicOfficerDto> getEconomicOfficerList(){
        return officerService.findAll();
    }

    @RequestMapping("object/state/all")
    @ResponseBody
    public List<String> fetchStateList() {
        return objectPropertyService.fetchStates();
    }

    @RequestMapping("object/maker/all")
    @ResponseBody
    public List<String> fetchMakerList() {
        return objectPropertyService.fetchMakers();
    }

    @RequestMapping(value = "object/filtered", method = RequestMethod.POST)
    @ResponseBody
    public List<ObjectPropertyDto> fetchFiltered(@RequestBody ObjectPropertyFilterDto filter) {
        return objectPropertyService.fetchFiltered(filter);
    }

}
