package com.db.campus.property.controller;

import com.db.campus.property.dto.CancellationActDto;
import com.db.campus.property.dto.CancellationProtocolRecordDto;
import com.db.campus.property.service.cancellation.CancellationActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CancellationActController {

    private final CancellationActService cancellationActService;

    @Autowired
    public CancellationActController(CancellationActService cancellationActService) {
        this.cancellationActService = cancellationActService;
    }

    @RequestMapping("/cancellation/act/all")
    @ResponseBody
    public List<CancellationActDto> fetchAll() {
        return cancellationActService.fetchAll();
    }

    @RequestMapping("/cancellation/protocol")
    @ResponseBody
    public List<CancellationProtocolRecordDto> protocol() {
        return cancellationActService.fetchProtocol();
    }

}
