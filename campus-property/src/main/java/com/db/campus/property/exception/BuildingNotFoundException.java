package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;

public class BuildingNotFoundException extends CampusPropertyException {

    private static final String MESSAGE = "Здание по адресу %s не найдено";
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public BuildingNotFoundException(String address) {
        super(STATUS, MESSAGE, address);
    }
}
