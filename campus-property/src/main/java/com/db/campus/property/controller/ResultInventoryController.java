package com.db.campus.property.controller;

import com.db.campus.property.dto.ResultInventoryDto;
import com.db.campus.property.service.resultInventory.ResultInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/result-inventory/list")
    @ResponseBody
    public List<ResultInventoryDto> fetchAll() {
        return resultInventoryService.fetchResultInventoryList();
    }
}
