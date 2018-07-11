package com.dm.onerosterapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class SchoolNotFoundException extends Exception {
    public SchoolNotFoundException(String message) {
        super(message);
    }
}