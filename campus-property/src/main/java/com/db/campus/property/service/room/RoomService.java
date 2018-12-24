package com.db.campus.property.service.room;

import com.db.campus.property.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<RoomDto> fetchRoomNumberList();

    List<Long> fetchDistinctNumbers();

    List<RoomDto> fetchAll(long buildingId);

    RoomDto fetch(long roomId);

    void save(RoomDto roomDto);

    void delete(RoomDto roomDto);

}
