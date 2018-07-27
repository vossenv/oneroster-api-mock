package com.dm.onerosterapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApiError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private List<String> errorMessageList = new ArrayList<>();

    public ApiError(HttpStatus status) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    public HttpStatus getStatus() {return status;}
    public void setStatus(HttpStatus status) {this.status = status;}
    public LocalDateTime getTimestamp() {return timestamp;}
    public void setTimestamp(LocalDateTime timestamp) {this.timestamp = timestamp;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public List<String> getErrorMessageList() {
        return errorMessageList;
    }
    public void setErrorMessageList(List<String> errorMessageList) {
        this.errorMessageList = errorMessageList;
    }

}

