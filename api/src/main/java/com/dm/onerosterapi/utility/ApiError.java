package com.dm.onerosterapi.utility;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class ApiError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private String debugMessage;

    ApiError(HttpStatus status) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    public HttpStatus getStatus() {return status;}
    public void setStatus(HttpStatus status) {this.status = status;}
    public LocalDateTime getTimestamp() {return timestamp;}
    public void setTimestamp(LocalDateTime timestamp) {this.timestamp = timestamp;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public String getDebugMessage() {return debugMessage;}
    public void setDebugMessage(String debugMessage) {this.debugMessage = debugMessage;}

}

