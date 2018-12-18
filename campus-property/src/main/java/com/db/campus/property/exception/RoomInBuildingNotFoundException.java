package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;

public class RoomInBuildingNotFoundException extends CampusPropertyException {

    private static final String MESSAGE = "Комната №%s не найдена по адресу %s";
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public RoomInBuildingNotFoundException(Long number, String address) {
        super(STATUS, MESSAGE, number.toString(), address);
    }
}
