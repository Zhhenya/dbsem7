package com.db.campus.property.service.room;

import com.db.campus.property.converter.RoomConverter;
import com.db.campus.property.dao.BuildingRepository;
import com.db.campus.property.dao.RoomRepository;
import com.db.campus.property.dto.RoomDto;
import com.db.campus.property.entity.RoomEntity;
import com.db.campus.property.exception.BuildingNotFoundException;
import com.db.campus.property.exception.RoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomConverter roomConverter;
    private final BuildingRepository buildingRepository;

    @Autowired
    public RoomServiceImp(RoomRepository roomRepository,
                          RoomConverter roomConverter,
                          BuildingRepository buildingRepository) {
        this.roomRepository = roomRepository;
        this.roomConverter = roomConverter;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public List<Long> fetchRoomNumberList() {
        return roomRepository.findAllNumbers();
    }

    @Override
    public List<RoomDto> fetchAll(long buildingId) {
        return roomConverter.convertAll(roomRepository.findAllByBuilding_Id(buildingId));
    }

    @Override
    public void delete(RoomDto roomDto) {
        roomRepository.deleteById(roomDto.getId());
    }

    @Override
    public void save(RoomDto roomDto) {
        RoomEntity roomEntity = new RoomEntity();
        if (roomDto.getId() != null) {
            roomEntity = roomRepository.findById(roomDto.getId())
                                       .orElseThrow(() -> new RoomNotFoundException(roomDto.getNumber()));
        }
        roomEntity.setFloor(roomDto.getFloor());
        roomEntity.setNumber(roomDto.getNumber());
        roomEntity.setBuilding(buildingRepository
                                       .findById(roomDto.getBuilding().getId())
                                       .orElseThrow(() -> new BuildingNotFoundException(roomDto.getBuilding()
                                                                                               .getAddress())));
        roomRepository.save(roomEntity);
    }
}