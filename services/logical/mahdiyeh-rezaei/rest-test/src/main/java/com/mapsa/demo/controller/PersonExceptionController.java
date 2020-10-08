package com.mapsa.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionController {
    @ExceptionHandler(value = PersonNotfoundException.class)
    public ResponseEntity<Object> exception(PersonNotfoundException exception) {
        return new ResponseEntity<>("Person not found :(", HttpStatus.NOT_FOUND);
    }
}
