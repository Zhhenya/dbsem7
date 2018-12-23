package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;

public class BuildingNotFoundException extends CampusPropertyException {

    private static final String MESSAGE_ADDRESS = "Здание по адресу %s не найдено";
    private static final String MESSAGE_ID = "Здание #%s не найдено";
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public BuildingNotFoundException(String address) {
        super(STATUS, MESSAGE_ADDRESS, address);
    }

    public BuildingNotFoundException(Long id) {
        super(STATUS, MESSAGE_ID, id.toString());
    }
}
