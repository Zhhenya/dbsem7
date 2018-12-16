package com.db.campus.property.service.room;

import com.db.campus.property.dto.RoomDto;

import java.util.List;

public interface RoomNumberService {
    List<RoomDto> fetchRoomNumberList();
}
