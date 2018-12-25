package com.db.campus.property.service.object;

import com.db.campus.property.dto.ObjectPropertyDto;
import com.db.campus.property.dto.ObjectPropertyFilterDto;
import com.db.campus.property.entity.ObjectPropertyEntity;
import com.db.campus.property.enums.ObjectState;

import java.util.List;

public interface ObjectPropertyService {

    List<ObjectPropertyDto> fetchAll();

    List<ObjectPropertyDto> fetchObjectList();

    List<ObjectPropertyDto> fetchFiltered(ObjectPropertyFilterDto objectPropertyFilterDto);

    List<String> fetchStates();

    List<String> fetchMakers();

    ObjectPropertyEntity save(ObjectPropertyDto objectPropertyDto);

    ObjectPropertyDto fetch(Long objectId);

    void changeState(ObjectPropertyEntity entity, ObjectState state);

}
