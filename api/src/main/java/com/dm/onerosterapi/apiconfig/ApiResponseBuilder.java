package com.dm.onerosterapi.apiconfig;

import com.dm.onerosterapi.model.SimplePage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public class ApiResponseBuilder {

    public static ResponseEntity<Object> buildApiResponse(Object body, SimplePage p){

        String urlNext = p.getURL() + "?limit=" + p.getLimit().toString()
                + "&offset=" + String.valueOf(p.getOffset() + p.getLimit()+1);

        String urlPrev = p.getURL() + "?limit=" + p.getLimit().toString()
                + "&offset=" + String.valueOf(Math.max(p.getOffset() - p.getLimit() - 1,0));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Limit", p.getLimit().toString());
        headers.add("Offset", p.getOffset().toString());
        headers.add("Next", urlNext);
        headers.add("Previous", urlPrev);
        headers.add("Result-Count", (String.valueOf(((List<?>)body).size())));

        return new ResponseEntity<>(body,headers, HttpStatus.OK);
    }



}
