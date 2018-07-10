package com.dm.onerosterapi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Search returned no results")
public class ClassNotFoundException extends Exception {
    public ClassNotFoundException (String message) {
        super(message);
    }
}