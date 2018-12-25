package com.db.campus.property.service.state;

import com.db.campus.property.converter.StateConverter;
import com.db.campus.property.dao.StateRepository;
import com.db.campus.property.dto.StateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateObjectPropertyServiceImpl implements StateObjectPropertyService {
    private StateRepository stateRepository;
    private StateConverter stateConverter;

    public StateObjectPropertyServiceImpl(StateRepository stateRepository,
                                          StateConverter stateConverter){
        this.stateRepository = stateRepository;
        this.stateConverter = stateConverter;
    }

    @Override
    public List<StateDto> fetchStateObjectProperty() {
        return stateConverter.convertAll(stateRepository.findAll());
    }
}