package com.db.campus.property.controller;

import com.db.campus.property.converter.EconomicOfficerConverter;
import com.db.campus.property.dao.EconomicOfficerRepository;
import com.db.campus.property.dto.EconomicOfficerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfficerController {

    private final EconomicOfficerRepository economicOfficerRepository;
    private final EconomicOfficerConverter economicOfficerConverter;

    @Autowired
    public OfficerController(EconomicOfficerRepository economicOfficerRepository,
                             EconomicOfficerConverter economicOfficerConverter) {
        this.economicOfficerRepository = economicOfficerRepository;
        this.economicOfficerConverter = economicOfficerConverter;
    }

    @RequestMapping("officer/all")
    @ResponseBody
    public List<EconomicOfficerDto> fetchAll() {
        return economicOfficerConverter.convertAll(economicOfficerRepository.findAll());
    }
}
