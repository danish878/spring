package com.danish.spring.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
        System.out.println("============>>>>>>>>>> inside @ExceptionHandler");
        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessages("Invalid ID requested");
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        ResponseEntity<StudentErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

        return responseEntity;

    }
}
