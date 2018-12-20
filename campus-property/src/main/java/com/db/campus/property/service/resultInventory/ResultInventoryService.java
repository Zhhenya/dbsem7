package com.db.campus.property.service.resultInventory;

import com.db.campus.property.dto.ObjectPropertyDto;
import com.db.campus.property.dto.ResultInventoryDto;

import java.util.List;

public interface ResultInventoryService {

    List<ResultInventoryDto> fetchResultInventoryList();

}
