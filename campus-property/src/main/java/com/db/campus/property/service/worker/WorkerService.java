package com.db.campus.property.service.worker;

import com.db.campus.property.dto.UniversityWorkerDto;

import java.util.List;

public interface WorkerService {

    List<UniversityWorkerDto> findAll();

    void save(UniversityWorkerDto workerDto);

}
