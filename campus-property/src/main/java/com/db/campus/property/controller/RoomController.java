package com.db.campus.property.controller;

import com.db.campus.property.dao.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @RequestMapping("room/number/all")
    @ResponseBody
    public List<Long> fetchAllDistinct() {
        return roomRepository.findAllNumbers();
    }

}
