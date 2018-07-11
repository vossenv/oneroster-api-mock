package com.dm.onerosterapi.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ClassNotFoundException extends Exception {
    public ClassNotFoundException (String message) {

        super(message);
    }
}