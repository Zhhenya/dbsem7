package com.db.campus.property.controller;

import com.db.campus.property.dto.RoomDto;
import com.db.campus.property.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping("room/number/all")
    @ResponseBody
    public List<Long> fetchAllDistinct() {
        return roomService.fetchDistinctNumbers();
    }

    @RequestMapping("room/all/{buildingId}")
    @ResponseBody
    public List<RoomDto> fetchAll(@PathVariable("buildingId") long buildingId) {
        return roomService.fetchAll(buildingId);
    }

    @RequestMapping(value = "room/save", method = RequestMethod.POST)
    @ResponseBody
    public Boolean save(@RequestBody RoomDto roomDto) {
        roomService.save(roomDto);
        return true;
    }

    @RequestMapping(value = "room/delete", method = RequestMethod.POST)
    @ResponseBody
    public Boolean delete(@RequestBody RoomDto roomDto) {
        roomService.delete(roomDto);
        return true;
    }

}
