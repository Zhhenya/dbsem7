package com.db.campus.property.converter;

import com.db.campus.property.dto.UniversityWorkerDto;
import com.db.campus.property.entity.UniversityWorkerEntity;
import org.springframework.stereotype.Service;

@Service
public class UniversityWorkerConverter extends CampusPropertyConverter<UniversityWorkerEntity, UniversityWorkerDto> {

    @Override
    public UniversityWorkerDto convert(UniversityWorkerEntity universityWorkerEntity) {
        UniversityWorkerDto workerDto = new UniversityWorkerDto();
        workerDto.setId(universityWorkerEntity.getId());
        workerDto.setName(universityWorkerEntity.getName());
        return workerDto;
    }
}
