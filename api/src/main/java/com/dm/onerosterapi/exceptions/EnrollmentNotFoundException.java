package com.dm.onerosterapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class EnrollmentNotFoundException extends Exception {
    public EnrollmentNotFoundException(String message) {
        super(message);
    }
}