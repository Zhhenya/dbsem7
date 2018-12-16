package com.db.campus.property.service.object;

import com.db.campus.property.dto.ObjectPropertyDto;

import java.util.List;

public interface ObjectPropertyService {

    List<ObjectPropertyDto> fetchAll();

    List<ObjectPropertyDto> fetchObjectList();

}
