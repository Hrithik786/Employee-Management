package com.mediquity.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleResourceNotFound(ResourceNotFoundException ex) {
        return ex.getMessage(); // or return a custom response object
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleGenericException(Exception ex) {
        return "An error occurred: " + ex.getMessage();
    }

}