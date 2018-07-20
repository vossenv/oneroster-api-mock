package com.dm.onerosterapi.model;

import java.util.Optional;

public class SimplePage {

    private static final int OFFSET_DEFAULT = 0;
    private static final int LIMIT_DEFAULT = 100;

    private Integer limit, offset;
    private String URL;

    private SimplePage(){
        this.limit = LIMIT_DEFAULT;
        this.offset = OFFSET_DEFAULT;
    }

    public SimplePage(Optional off, Optional lim, String URL){
        this();
        if (off.isPresent()) {this.offset = (Integer) off.get();}
        if (lim.isPresent()) {this.limit = (Integer) lim.get();}
        this.URL = URL;
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
