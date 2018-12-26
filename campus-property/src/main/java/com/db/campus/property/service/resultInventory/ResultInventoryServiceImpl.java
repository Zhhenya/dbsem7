package com.db.campus.property.service.resultInventory;

import com.db.campus.property.converter.ResultInventoryConverter;
import com.db.campus.property.dao.ResultInventoryRepository;
import com.db.campus.property.dto.ResultInventoryDto;
import com.db.campus.property.entity.ResultInventoryEntity;
import com.db.campus.property.entity.ResultInventoryEntityPK;
import com.db.campus.property.exception.ResultNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<ResultInventoryDto> fetchResultInventoryListByInventoryId(long inventoryId) {
        return resultInventoryConverter.convertAll(
                resultInventoryRepository.findAllByInventory_Id(inventoryId)
                                                  );
    }

    public List<ResultInventoryDto> fetchResultInventoryListByInventoryIdAndRoomId(long inventoryId, long roomId) {
        return resultInventoryConverter.convertAll(
                resultInventoryRepository.findAllByInventory_IdAndObjectProperty_Room_Id(inventoryId, roomId)
                                                  );
    }

    @Override
    public List<ResultInventoryDto> fetchResultInventoryListInBuilding(long inventoryId, long buildingId) {
        return resultInventoryConverter.convertAll(
                resultInventoryRepository.findAllByInventory_IdAndObjectProperty_Room_Building_Id(inventoryId,
                                                                                                  buildingId));
    }

    @Transactional
    @Override
    public void saveResultInventories(List<ResultInventoryDto> results) {
        results.forEach(resultInventoryDto -> {
            ResultInventoryEntity entity = resultInventoryRepository
                    .findById(new ResultInventoryEntityPK(resultInventoryDto.getId(),
                                                          resultInventoryDto.getInventory().getId()))
                    .orElseThrow(() -> new ResultNotFoundException(resultInventoryDto.getId()));
            entity.setResult(resultInventoryDto.getResult());
            resultInventoryRepository.save(entity);
        });
    }
}
