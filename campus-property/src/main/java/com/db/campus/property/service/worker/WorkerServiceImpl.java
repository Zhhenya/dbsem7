package com.db.campus.property.service.worker;

import com.db.campus.property.converter.UniversityWorkerConverter;
import com.db.campus.property.dao.UniversityWorkerRepository;
import com.db.campus.property.dto.UniversityWorkerDto;
import com.db.campus.property.entity.UniversityWorkerEntity;
import com.db.campus.property.exception.WorkerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final UniversityWorkerRepository universityWorkerRepository;
    private final UniversityWorkerConverter universityWorkerConverter;

    @Autowired
    public WorkerServiceImpl(UniversityWorkerRepository universityWorkerRepository,
                             UniversityWorkerConverter universityWorkerConverter) {
        this.universityWorkerRepository = universityWorkerRepository;
        this.universityWorkerConverter = universityWorkerConverter;
    }

    @Override
    public List<UniversityWorkerDto> findAll() {
        return universityWorkerConverter.convertAll(universityWorkerRepository.findAll());
    }

    @Override
    public void save(UniversityWorkerDto universityWorkerDto) {
        UniversityWorkerEntity workerEntity = universityWorkerRepository.findById(universityWorkerDto.getId())
                                                                        .orElseThrow(() -> new WorkerNotFoundException(
                                                                                universityWorkerDto.getName()));
        workerEntity.setName(universityWorkerDto.getName());
        universityWorkerRepository.save(workerEntity);
    }
}
