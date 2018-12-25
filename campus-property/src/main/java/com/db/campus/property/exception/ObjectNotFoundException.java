package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends CampusPropertyException {

    private static final String MESSAGE = "Объект №%s не найден";
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public ObjectNotFoundException(String number) {
        super(STATUS, MESSAGE, number);
    }
}
