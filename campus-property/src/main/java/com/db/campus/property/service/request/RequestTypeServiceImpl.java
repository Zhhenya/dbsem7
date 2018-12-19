package com.db.campus.property.service.request;

import com.db.campus.property.converter.RequestTypeConverter;
import com.db.campus.property.dao.TypeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestTypeServiceImpl implements RequestTypeService {

    private final TypeRequestRepository typeRequestRepository;
    private final RequestTypeConverter requestTypeConverter;

    @Autowired

    public RequestTypeServiceImpl(TypeRequestRepository typeRequestRepository,
                                  RequestTypeConverter requestTypeConverter) {
        this.typeRequestRepository = typeRequestRepository;
        this.requestTypeConverter = requestTypeConverter;
    }

    @Override
    public List<String> fetchRequestTypeList() {
        return requestTypeConverter.convertAll(typeRequestRepository.findAll());
    }

}
