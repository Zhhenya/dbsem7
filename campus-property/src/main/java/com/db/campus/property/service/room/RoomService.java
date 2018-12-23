package com.db.campus.property.service.room;

import com.db.campus.property.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<Long> fetchRoomNumberList();

    List<RoomDto> fetchAll(long buildingId);

    void save(RoomDto roomDto);

    void delete(RoomDto roomDto);

}
