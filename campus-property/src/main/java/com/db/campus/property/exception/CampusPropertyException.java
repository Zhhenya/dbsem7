package com.db.campus.property.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CampusPropertyException extends ResponseStatusException {

    public CampusPropertyException(HttpStatus status, String message, String... parameters) {
        super(status, String.format(message, parameters));
    }
}
