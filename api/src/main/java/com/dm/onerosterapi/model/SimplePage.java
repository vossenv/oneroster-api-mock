package com.dm.onerosterapi.model;

import com.dm.onerosterapi.exceptions.InvalidParameterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimplePage {

    private int limit = 100;
    private int offset = 0;
    private String URL;
    private List<String> errors = new ArrayList<>();

    public SimplePage(Optional<String> off, Optional<String> lim, String URL) throws InvalidParameterException {

        lim.ifPresent(s -> this.limit = validateParameter("limit", s, 1, 1000));
        off.ifPresent(s -> this.offset = validateParameter("offset", s, 0, Integer.MAX_VALUE));

        if (errors.size() > 0) {
            InvalidParameterException e = new InvalidParameterException();
            e.getErrorList().addAll(errors);
            throw e;
        }

        this.URL = URL;
    }

    private int validateParameter (String type, String param, int min, int max){
        try {
            int p = Integer.parseInt(param);
            if (p < min || p > max){
                errors.add("Valid range exceeded. " + type + " must be between " + min + " and " + max);
                return 0;
            } else return p;
        }
        catch (NumberFormatException | NullPointerException e){
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
