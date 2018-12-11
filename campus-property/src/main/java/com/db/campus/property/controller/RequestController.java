package com.db.campus.property.controller;

import com.db.campus.property.converter.RequestConverter;
import com.db.campus.property.dao.RequestRepository;
import com.db.campus.property.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestController {

    private final RequestConverter requestConverter;
    private final RequestRepository requestRepository;

    @Autowired
    public RequestController(RequestConverter requestConverter,
                             RequestRepository requestRepository) {
        this.requestConverter = requestConverter;
        this.requestRepository = requestRepository;
    }

    @RequestMapping("/request/list")
    @ResponseBody
    public List<RequestDto> getRequestList() {
        return requestConverter.convertAll(requestRepository.findAll());
    }

}
