package com.db.campus.property.controller.request;

import com.db.campus.property.converter.RequestConverter;
import com.db.campus.property.dao.RequestRepository;
import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.service.request.RequestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {

    private final RequestConverter requestConverter;
    private final RequestRepository requestRepository;
    private final RequestTypeService requestTypeService;

    @Autowired
    public RequestController(RequestConverter requestConverter,
                             RequestRepository requestRepository,
                             RequestTypeService requestTypeService) {
        this.requestConverter = requestConverter;
        this.requestRepository = requestRepository;
        this.requestTypeService = requestTypeService;
    }

    @RequestMapping("/request/type/list")
    @ResponseBody
    public List<String> getRequestTypeList() {
        return requestTypeService.fetchRequestTypeList();
    }

    @RequestMapping(value = "/request/create", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody RequestDto requestDto) {

    }

    @RequestMapping("/request/list")
    @ResponseBody
    public List<RequestDto> getRequestList() {
        return requestConverter.convertAll(requestRepository.findAll());
    }

}
