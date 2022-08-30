package com.pauloeduardocosta.email.rs.exception;

import com.pauloeduardocosta.email.service.exception.FalhaNoEnvioDeEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(FalhaNoEnvioDeEmailException.class)
    public ResponseEntity<StandardError> falhaNoEnvioDeEmail(FalhaNoEnvioDeEmailException e, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}
