package com.db.campus.property.controller;

import com.db.campus.property.converter.RoomConverter;
import com.db.campus.property.dao.RoomRepository;
import com.db.campus.property.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private final RoomRepository roomRepository;
    private final RoomConverter roomConverter;

    @Autowired
    public RoomController(RoomRepository roomRepository, RoomConverter roomConverter) {
        this.roomRepository = roomRepository;
        this.roomConverter = roomConverter;
    }

    @RequestMapping("room/all/distinct")
    @ResponseBody
    public List<RoomDto> fetchAllDistinct() {
        return roomConverter.convertAll(roomRepository.findAll());
    }

}
