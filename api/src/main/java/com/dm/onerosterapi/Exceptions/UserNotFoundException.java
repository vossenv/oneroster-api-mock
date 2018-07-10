package com.dm.onerosterapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Search returned no results")
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}