package com.dm.onerosterapi.model;

import com.dm.onerosterapi.exceptions.InvalidParameterException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SimplePage {

    private int limit = 100;
    private int offset = 0;
    private String URL;
    private List<String> errors = new ArrayList<>();

    public SimplePage(HttpServletRequest request) throws InvalidParameterException {

        String lim = request.getParameter("limit");
        String off = request.getParameter("offset");
        String host = request.getHeader("host");

        this.URL = request.getRequestURL().toString();

        try {

            String [] urlParts = URL.split(host);
            this.URL = urlParts[0] + host + request.getAttribute("Auth-URL").toString();
            if (urlParts.length > 1) {this.URL += urlParts[1];}

        } catch (NullPointerException e) {/* Do nothing - No attribute */}


        if (lim != null) {
            this.limit = validateParameter("limit", lim, 1, 1000);
        }

        if (off != null) {
            this.offset = validateParameter("offset", off, 0, Integer.MAX_VALUE);
        }

        if (errors.size() > 0) {
            InvalidParameterException e = new InvalidParameterException();
            e.getErrorList().addAll(errors);
            throw e;
        }
    }

    private int validateParameter (String type, String param, int min, int max){
        try {
            int p = Integer.parseInt(param);
            if (p < min || p > max){
                errors.add("Valid range exceeded for " + type + ". Must be between " + min + " and " + max);
                return 0;
            } else return p;
        }
        catch (NumberFormatException e){
           errors.add("Error parsing " + type + ": '" + param + "'.  Please enter a valid integer between " + min + " and " + max);
           return 0;
        }
    }

    public String getURL() {return URL;}

    public void setURL(String URL) {this.URL = URL;}

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
