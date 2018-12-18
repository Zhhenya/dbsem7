package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;

public class RoomNotFoundException extends CampusPropertyException {

    private static final String MESSAGE = "Комната №%s не найдена";
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public RoomNotFoundException(Long requestId) {
        super(STATUS, MESSAGE, requestId.toString());
    }
}
