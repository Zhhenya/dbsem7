package com.db.campus.property.controller;

import com.db.campus.property.dto.ObjectPropertyDto;
import com.db.campus.property.dto.RoomDto;
import com.db.campus.property.service.object.ObjectPropertyService;
import com.db.campus.property.service.room.RoomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObjectPropertyController {

    private final ObjectPropertyService objectPropertyService;
    private final RoomNumberService roomNumberService;

    @Autowired
    public ObjectPropertyController(ObjectPropertyService objectPropertyService,
                                    RoomNumberService roomNumberService) {
        this.objectPropertyService = objectPropertyService;
        this.roomNumberService = roomNumberService;
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

    @RequestMapping("/objectProperty")
    @ResponseBody
    public List<ObjectPropertyDto> getObjectPropertyList() {
        return objectPropertyService.fetchObjectList();
    }

}
