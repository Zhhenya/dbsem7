package com.db.campus.property.controller;

import com.db.campus.property.dto.EconomicOfficerDto;
import com.db.campus.property.service.officer.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfficerController {

    private final OfficerService officerService;

    @Autowired
    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }

    @RequestMapping("officer/all")
    @ResponseBody
    public List<EconomicOfficerDto> fetchAll() {
        return officerService.findAll();
    }

    @RequestMapping(value = "officer/save", method = RequestMethod.POST)
    @ResponseBody
    public Boolean save(@RequestBody EconomicOfficerDto officerDto) {
        officerService.save(officerDto);
        return true;
    }

    @RequestMapping("officer/{id}")
    @ResponseBody
    public EconomicOfficerDto fetch(@PathVariable("id") Long id) {
        return officerService.fetch(id);
    }

}
