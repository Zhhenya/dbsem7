package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;

public class RequestNotFoundException extends CampusPropertyException {

    private static final String MESSAGE = "Заяка №%s не найдена";
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public RequestNotFoundException(Long requestId) {
        super(STATUS, MESSAGE, requestId.toString());
    }
}
