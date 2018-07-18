package com.dm.onerosterapi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseHandler {


    public static ResponseEntity<Object> buildApiResponse(Object body, int limit, int offset){


        HttpHeaders headers = new HttpHeaders();
        headers.add("hello", "there");


        return new ResponseEntity<Object>(body,headers, HttpStatus.OK);
    }

}
