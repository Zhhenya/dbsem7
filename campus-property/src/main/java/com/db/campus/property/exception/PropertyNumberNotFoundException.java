package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;

public class PropertyNumberNotFoundException extends CampusPropertyException {

    private static final String MESSAGE = "Объект имущества с инвентарным номером %s не найден";
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public PropertyNumberNotFoundException(String propertyNumber) {
        super(STATUS, MESSAGE, propertyNumber);
    }
}
