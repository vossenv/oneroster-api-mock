package com.dm.onerosterapi.apiconfig;

import com.dm.onerosterapi.exceptions.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
//@ControllerAdvice(basePackages = "com.dm.onerosterapi")
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidParameterException.class)
    protected ResponseEntity<Object> handleInvalidParameterException( InvalidParameterException e ) {
        return buildResponseEntity(e, ApiMessages.INVALID_PARAMETER, HttpStatus.BAD_REQUEST, e.getErrorList());
    }

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFound( UserNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_USER_MESSAGE, HttpStatus.NOT_FOUND, e.getErrorList());
    }

    @ExceptionHandler(ClassOfCourseNotFoundException.class)
    protected ResponseEntity<Object> handleSchoolClassNotFound( ClassOfCourseNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_CLASS_MESSAGE, HttpStatus.NOT_FOUND, e.getErrorList());
    }

    @ExceptionHandler(CourseNotFoundException.class)
    protected ResponseEntity<Object> handleCourseNotFound( CourseNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_COURSE_MESSAGE, HttpStatus.NOT_FOUND, e.getErrorList());
    }

    @ExceptionHandler(SchoolNotFoundException.class)
    protected ResponseEntity<Object> handleSchoolNotFound( SchoolNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_SCHOOL_MESSAGE, HttpStatus.NOT_FOUND, e.getErrorList());
    }

    @ExceptionHandler(EnrollmentNotFoundException.class)
    protected ResponseEntity<Object> handleEnrollmentNotFound( EnrollmentNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_ENROLLMENT_MESSAGE, HttpStatus.NOT_FOUND, e.getErrorList());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFound( ResourceNotFoundException e ) {
        return buildResponseEntity(e, ApiMessages.NO_RESULTS, HttpStatus.NOT_FOUND, e.getErrorList());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported (
            HttpRequestMethodNotSupportedException e, HttpHeaders headers, HttpStatus status, WebRequest request){
        return buildResponseEntity(e, ApiMessages.UNSUPPORTED_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object>  handleNoHandlerFoundException(
            NoHandlerFoundException e, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> errorDetails = new ArrayList<>();
        errorDetails.add("The URL is invalid: " + e.getRequestURL());

        return buildResponseEntity(e, ApiMessages.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND, errorDetails);
    }

    @ExceptionHandler
    public String constraintViolationHandler(ConstraintViolationException ex) {
        return ex.getConstraintViolations().iterator().next()
                .getMessage();
    }


    private ResponseEntity<Object> buildResponseEntity(Exception e, String message, HttpStatus status, List<String> errorDetails) {

        ApiError apiError = new ApiError(status);
        apiError.setMessage(message);
        apiError.getErrorMessageList().addAll(errorDetails);
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }

    private ResponseEntity<Object> buildResponseEntity(Exception e, String message, HttpStatus status) {
        List<String> errorDetails = new ArrayList<>();
        errorDetails.add(ExceptionUtils.getRootCauseMessage(e));
        return buildResponseEntity(e, message, status, errorDetails);
    }



}