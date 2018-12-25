package com.db.campus.property.converter;

import com.db.campus.property.dto.StateDto;
import com.db.campus.property.entity.StateEntity;
import org.springframework.stereotype.Service;

@Service
public class StateConverter extends CampusPropertyConverter<StateEntity, StateDto> {
    @Override
    public StateDto convert(StateEntity stateEntity) {
        StateDto stateDto = new StateDto();
        stateDto.setId(stateEntity.getId());
        stateDto.setState(stateEntity.getName());
        return stateDto;
    }
}