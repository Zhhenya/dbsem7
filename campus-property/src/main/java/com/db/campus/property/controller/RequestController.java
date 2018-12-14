package com.db.campus.property.controller;

import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.service.request.RequestService;
import com.db.campus.property.service.request.RequestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {

    private final RequestService requestService;
    private final RequestTypeService requestTypeService;

    @Autowired
    public RequestController(RequestService requestService, RequestTypeService requestTypeService) {
        this.requestService = requestService;
        this.requestTypeService = requestTypeService;
    }

    @RequestMapping("request/processing/list/{id}")
    @ResponseBody
    public List<RequestDto> fetchProcessingRequestList(@PathVariable("id") long workerId) {
        return requestService.fetchProcessingRequestList(workerId);
    }

    @RequestMapping("/request/type/list")
    @ResponseBody
    public List<String> getRequestTypeList() {
        return requestTypeService.fetchRequestTypeList();
    }

    @RequestMapping(value = "/request/create", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody RequestDto requestDto) {
        requestService.save(requestDto);
    }

    @RequestMapping("/request/list")
    @ResponseBody
    public List<RequestDto> getRequestList() {
        return requestService.fetchRequestList();
    }

}
