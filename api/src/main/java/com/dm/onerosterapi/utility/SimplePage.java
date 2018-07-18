package com.dm.onerosterapi.utility;

import java.util.Optional;

public class SimplePage {

    private static final int OFFSET_DEFAULT = 0;
    private static final int LIMIT_DEFAULT = 100;

    private Integer offset, limit;
    private AllowedTypes dataType;
    private String URL;

    private SimplePage(){
        this.limit = LIMIT_DEFAULT;
        this.offset = OFFSET_DEFAULT;
    }

    public SimplePage(Optional off, Optional lim, AllowedTypes dataType){
        this();
        if (off.isPresent()) {this.offset = (int) off.get();}
        if (lim.isPresent()) {this.limit = (int) lim.get();}
        this.dataType = dataType;
        this.URL = dataType.getObjType();
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

    public AllowedTypes getDataType() {
        return dataType;
    }

    public void setDataType(AllowedTypes dataType) {
        this.dataType = dataType;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
