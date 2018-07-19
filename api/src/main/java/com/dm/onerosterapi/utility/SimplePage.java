package com.dm.onerosterapi.utility;

import java.util.Optional;

public class SimplePage {

    private static final int OFFSET_DEFAULT = 0;
    private static final int LIMIT_DEFAULT = 100;
    private static final String baseURL = "https://oneroster.thenewcarag.com";

    private Integer limit, offset;
    private String relativeURL;

    private SimplePage(){
        this.limit = LIMIT_DEFAULT;
        this.offset = OFFSET_DEFAULT;
    }

    public SimplePage(Optional off, Optional lim, String relativeURL){
        this();
        if (off.isPresent()) {this.offset = (Integer) off.get();}
        if (lim.isPresent()) {this.limit = (Integer) lim.get();}
        this.relativeURL = relativeURL;
    }

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

    public String getRelativeURL() {return relativeURL;}

    public void setRelativeURL(String relativeURL) {this.relativeURL = relativeURL;}
}
