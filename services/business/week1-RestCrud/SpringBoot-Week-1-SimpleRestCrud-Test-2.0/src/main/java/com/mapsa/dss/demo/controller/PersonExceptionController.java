package com.mapsa.dss.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionController {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> exception(PersonNotFoundException exception){
        return new ResponseEntity<>("Person not Found :((((((((", HttpStatus.NOT_FOUND);
    }
}
