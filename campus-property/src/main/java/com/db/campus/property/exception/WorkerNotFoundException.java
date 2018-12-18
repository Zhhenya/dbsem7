package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;

public class WorkerNotFoundException extends CampusPropertyException {

    private static final String MESSAGE = "Работник по имени %s не найден";
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public WorkerNotFoundException(String name) {
        super(STATUS, MESSAGE, name);
    }
}
