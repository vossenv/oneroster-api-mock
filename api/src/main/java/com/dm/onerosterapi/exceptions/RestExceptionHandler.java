package com.dm.onerosterapi.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported (HttpRequestMethodNotSupportedException e, HttpHeaders headers, HttpStatus status, WebRequest request){
        return buildResponseEntity(e, ApiMessages.UNSUPPORTED_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFound( UserNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_USER_MESSAGE, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClassNotFoundException.class)
    protected ResponseEntity<Object> handleClassNotFound( ClassNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_CLASS_MESSAGE, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    protected ResponseEntity<Object> handleCourseNotFound( CourseNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_COURSE_MESSAGE, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SchoolNotFoundException.class)
    protected ResponseEntity<Object> handleSchoolNotFound( SchoolNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_SCHOOL_MESSAGE, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EnrollmentNotFoundException.class)
    protected ResponseEntity<Object> handleEnrollmentNotFound( EnrollmentNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_ENROLLMENT_MESSAGE, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Object> buildResponseEntity(Exception e, String message, HttpStatus status) {

        ApiError apiError = new ApiError(status);
        apiError.setMessage(message);
        apiError.setDebugMessage(ExceptionUtils.getRootCauseMessage(e));

        return new ResponseEntity<>(apiError, apiError.getStatus());
    }



}