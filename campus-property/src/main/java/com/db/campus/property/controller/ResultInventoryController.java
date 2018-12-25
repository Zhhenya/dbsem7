package com.db.campus.property.controller;

import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.dto.ResultInventoryDto;
import com.db.campus.property.service.resultInventory.ResultInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultInventoryController {

    private final ResultInventoryService resultInventoryService;

    @Autowired
    public ResultInventoryController(
            ResultInventoryService resultInventoryService
    ) {
        this.resultInventoryService = resultInventoryService;
    }

    @RequestMapping("/inventory/result-inventory/list")
    @ResponseBody
    public List<ResultInventoryDto> fetchAll() {
        return resultInventoryService.fetchResultInventoryList();
    }

    @RequestMapping("/inventory/{inventoryId}/result-inventory")
    @ResponseBody
    public List<ResultInventoryDto> fetchResultInventoryByInventoryId(
            @PathVariable("inventoryId") long inventoryId
    ) {
        return resultInventoryService.fetchResultInventoryListByInventoryId(inventoryId);
    }

    @RequestMapping("/inventory/{inventoryId}/result-inventory/{roomId}")
    @ResponseBody
    public List<ResultInventoryDto> fetchResultInventoryByInventoryIdAndRoomId(
            @PathVariable("inventoryId") long inventoryId,
            @PathVariable("roomId") long roomId
    ) {
        return resultInventoryService.fetchResultInventoryListByInventoryIdAndRoomId(inventoryId, roomId);
    }
}
