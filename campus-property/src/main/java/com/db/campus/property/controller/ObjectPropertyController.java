package com.db.campus.property.controller;

import com.db.campus.property.dto.*;
import com.db.campus.property.service.builder.BuildingAddressService;
import com.db.campus.property.service.object.ObjectPropertyService;
import com.db.campus.property.service.officer.OfficerService;
import com.db.campus.property.service.room.RoomService;
import com.db.campus.property.service.state.StateObjectPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObjectPropertyController {

    private final ObjectPropertyService objectPropertyService;
    private final RoomService roomService;
    private final BuildingAddressService buildingAddressService;
    private final StateObjectPropertyService stateObjectPropertyService;
    private final OfficerService officerService;


    @Autowired
    public ObjectPropertyController(ObjectPropertyService objectPropertyService,
                                    RoomService roomService,
                                    BuildingAddressService buildingAddressService,
                                    StateObjectPropertyService stateObjectPropertyService,
                                    OfficerService officerService) {
        this.objectPropertyService = objectPropertyService;
        this.roomService = roomService;
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
        return roomService.fetchRoomNumberList();
    }

    @RequestMapping("object/building")
    @ResponseBody
    public List<BuildingDto> fetchBuildingAddressList(){
        return buildingAddressService.fetchBuildingAddress();
    }

    @RequestMapping("object/state")
    @ResponseBody
    public List<StateDto> fetchStateObjectProperty(){
        return stateObjectPropertyService.fetchStateObjectProperty();
    }

    @RequestMapping("/objectProperty")
    @ResponseBody
    public List<ObjectPropertyDto> fetchObjectPropertyList() {
        return objectPropertyService.fetchObjectList();
    }

    @RequestMapping(value = "object/{id}")
    @ResponseBody
    public ObjectPropertyDto fetchObject(@PathVariable("id") long objectId) {
        return objectPropertyService.fetch(objectId);
    }

    @RequestMapping("object/economicOfficers")
    @ResponseBody
    public List<EconomicOfficerDto> fetchEconomicOfficerList(){
        return officerService.findAll();
    }

    @RequestMapping(value = "object/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody ObjectPropertyDto objectPropertyDto){
        objectPropertyService.save(objectPropertyDto);
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
