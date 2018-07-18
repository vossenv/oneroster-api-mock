package com.dm.onerosterapi.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseHandler {

    public static ResponseEntity<Object> buildApiResponse(Object body, SimplePage p){

        // For show only at them moment -- will need to carry object types in page data
        String urlBase = "https://oneroster.thenewcarag.com/" + p.getURL();

        String urlNext = urlBase + "?limit=" + p.getLimit().toString()
                + "&offset=" + String.valueOf(p.getOffset() + p.getLimit()+1);

        String urlPrev = urlBase + "?limit=" + p.getLimit().toString()
                + "&offset=" + String.valueOf(Math.max(p.getOffset() - p.getLimit(),0) - 1);

        HttpHeaders headers = new HttpHeaders();
        headers.add("limit", p.getLimit().toString());
        headers.add("offset", p.getOffset().toString());
        headers.add("Next", urlNext);
        headers.add("Previous", urlPrev);

        return new ResponseEntity<Object>(body,headers, HttpStatus.OK);
    }

}
