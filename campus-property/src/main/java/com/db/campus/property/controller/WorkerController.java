package com.db.campus.property.controller;

import com.db.campus.property.dto.UniversityWorkerDto;
import com.db.campus.property.service.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping(value = "worker/save", method = RequestMethod.POST)
    @ResponseBody
    public Boolean save(@RequestBody UniversityWorkerDto workerDto) {
        workerService.save(workerDto);
        return true;
    }

}
