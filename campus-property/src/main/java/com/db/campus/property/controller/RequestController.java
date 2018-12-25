package com.db.campus.property.controller;

import com.db.campus.property.dto.RequestDto;
import com.db.campus.property.enums.RequestState;
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

    @RequestMapping("request/{status}/list/worker/{id}")
    @ResponseBody
    public List<RequestDto> fetchWorkerRequestList(@PathVariable("id") long workerId,
                                                   @PathVariable("status") String status) {
        return requestService.fetchWorkerRequestList(workerId, RequestState.valueOf(status.toUpperCase()));
    }

    @RequestMapping("request/{status}/list/accountant/{id}")
    @ResponseBody
    public List<RequestDto> fetchAccountantRequestList(@PathVariable("id") long accountantId,
                                                       @PathVariable("status") String status) {
        return requestService.fetchAccountantRequestList(accountantId, RequestState.valueOf(status.toUpperCase()));
    }

    @RequestMapping("request/{status}/list/officer/{id}")
    @ResponseBody
    public List<RequestDto> fetchOfficerRequestList(@PathVariable("id") long officerId,
                                                    @PathVariable("status") String status) {
        return requestService.fetchOfficerRequestList(officerId, RequestState.valueOf(status.toUpperCase()));
    }

    @RequestMapping("request/{status}/list")
    @ResponseBody
    public List<RequestDto> fetchRequestList(@PathVariable("status") String status) {
        return requestService.fetchRequestList(RequestState.valueOf(status.toUpperCase()));
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

    @RequestMapping(value = "/approveRequest", method = RequestMethod.POST)
    @ResponseBody
    public void approve(@RequestBody Long requestId) {
        requestService.approve(requestId);
    }

    @RequestMapping(value = "/request/cancelObjects", method = RequestMethod.POST)
    @ResponseBody
    public void cancelObjects(@RequestBody Long requestId) {
        requestService.cancelObjects(requestId);
    }

    @RequestMapping(value = "/request/startProcessing", method = RequestMethod.POST)
    @ResponseBody
    public void startRequestProcessing(@RequestBody Long requestId) {
        requestService.startRequestProcessing(requestId);
    }

    @RequestMapping(value = "/request/markAsReady", method = RequestMethod.POST)
    @ResponseBody
    public void markRequestAsReady(@RequestBody Long requestId) {
        requestService.markRequestAsReady(requestId);
    }

    @RequestMapping("/request/list")
    @ResponseBody
    public List<RequestDto> getRequestList() {
        return requestService.fetchRequestList();
    }

}
