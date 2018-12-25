package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;

public class BuildingConstraintException extends CampusPropertyException {

    private static final String MESSAGE = "Нельзя удалить здание, связанное с комнатами";
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public BuildingConstraintException() {
        super(STATUS, MESSAGE);
    }

}
