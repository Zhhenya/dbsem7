package com.db.campus.property.converter;

import com.db.campus.property.dto.RoomDto;
import com.db.campus.property.entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomConverter extends CampusPropertyConverter<RoomEntity, RoomDto> {

    private final BuildingConverter buildingConverter;

    @Autowired
    public RoomConverter(BuildingConverter buildingConverter) {
        this.buildingConverter = buildingConverter;
    }

    @Override
    public RoomDto convert(RoomEntity roomEntity) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(roomEntity.getId());
        roomDto.setNumber(roomEntity.getNumber());
        roomDto.setFloor(roomEntity.getFloor());
        roomDto.setBuilding(buildingConverter.convert(roomEntity.getBuilding()));
        return roomDto;
    }
}
