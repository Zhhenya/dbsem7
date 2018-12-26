package com.db.campus.property.controller;

import com.db.campus.property.dto.ResultInventoryDto;
import com.db.campus.property.service.resultInventory.ResultInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/inventory/{inventoryId}/result-inventory/building/{buildingId}")
    @ResponseBody
    public List<ResultInventoryDto> fetchResultInventoryInBuilding(@PathVariable("inventoryId") long inventoryId,
                                                                   @PathVariable("buildingId") long buildingId) {
        return resultInventoryService.fetchResultInventoryListInBuilding(inventoryId, buildingId);
    }

    @RequestMapping("/inventory/result/save")
    @ResponseBody
    public Boolean saveResults(@RequestBody List<ResultInventoryDto> inventories) {
        resultInventoryService.saveResultInventories(inventories);
        return true;
    }

}
