package com.db.campus.property.service.resultInventory;

import com.db.campus.property.converter.ResultInventoryConverter;
import com.db.campus.property.dao.ResultInventoryRepository;
import com.db.campus.property.dto.ResultInventoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultInventoryServiceImpl implements ResultInventoryService {

    private final ResultInventoryRepository resultInventoryRepository;
    private final ResultInventoryConverter resultInventoryConverter;

    @Autowired
    public ResultInventoryServiceImpl(
            ResultInventoryRepository resultInventoryRepository,
            ResultInventoryConverter resultInventoryConverter
    ) {
        this.resultInventoryRepository = resultInventoryRepository;
        this.resultInventoryConverter = resultInventoryConverter;
    }

    public List<ResultInventoryDto> fetchResultInventoryList() {
        return resultInventoryConverter.convertAll(
                resultInventoryRepository.findAll()
        );
    }

}
