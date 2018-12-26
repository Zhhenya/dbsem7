package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;

public class ResultNotFoundException extends CampusPropertyException {

    private static final String MESSAGE = "Результат инвентаризации №%s не найден";
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public ResultNotFoundException(Long id) {
        super(STATUS, MESSAGE, id.toString());
    }
}
