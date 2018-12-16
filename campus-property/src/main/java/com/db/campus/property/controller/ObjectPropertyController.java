package com.db.campus.property.controller;

import com.db.campus.property.dto.ObjectPropertyDto;
import com.db.campus.property.service.object.ObjectPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObjectPropertyController {

    private final ObjectPropertyService objectPropertyService;

    @Autowired
    public ObjectPropertyController(ObjectPropertyService objectPropertyService) {
        this.objectPropertyService = objectPropertyService;
    }

    @RequestMapping("/object/list")
    @ResponseBody
    public List<ObjectPropertyDto> fetchAll() {
        return objectPropertyService.fetchAll();
    }

}
