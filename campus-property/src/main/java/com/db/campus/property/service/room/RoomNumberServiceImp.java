package com.db.campus.property.service.room;

import com.db.campus.property.converter.RoomConverter;
import com.db.campus.property.dao.RoomRepository;
import com.db.campus.property.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomNumberServiceImp implements RoomNumberService {
    private final RoomRepository roomRepository;
    private final RoomConverter roomConverter;

    @Autowired
    public RoomNumberServiceImp(RoomRepository roomRepository,
                                RoomConverter roomConverter) {
        this.roomRepository = roomRepository;
        this.roomConverter = roomConverter;
    }

    @Override
    public List<RoomDto> fetchRoomNumberList() {
        return roomConverter.convertAll(roomRepository.findAll());
    }
}