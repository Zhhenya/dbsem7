package com.db.campus.property.controller;

import com.db.campus.property.converter.CancellationActConverter;
import com.db.campus.property.dao.CancellationActRepository;
import com.db.campus.property.dto.CancellationActDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CancellationActController {

    private final CancellationActRepository cancellationActRepository;
    private final CancellationActConverter cancellationActConverter;

    @Autowired
    public CancellationActController(CancellationActRepository cancellationActRepository,
                                     CancellationActConverter cancellationActConverter) {
        this.cancellationActRepository = cancellationActRepository;
        this.cancellationActConverter = cancellationActConverter;
    }

    @RequestMapping("/cancellation/act/all")
    @ResponseBody
    public List<CancellationActDto> fetchAll() {
        return cancellationActConverter.convertAll(cancellationActRepository.findAll());
    }

}
