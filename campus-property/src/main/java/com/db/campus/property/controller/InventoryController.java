package com.db.campus.property.controller;

import com.db.campus.property.dto.InventoryDto;
import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.service.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

	@RequestMapping("/inventory/")
    @ResponseBody
    public List<InventoryDto> getInventoryList() {
        return inventoryService.fetchInventoryList();
    }
}
