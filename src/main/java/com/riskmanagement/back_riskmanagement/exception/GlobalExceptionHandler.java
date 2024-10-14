package com.riskmanagement.back_riskmanagement.exception;

import com.riskmanagement.back_riskmanagement.exception.riskmanagement.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de excepciones personalizadas (de cada módulo), con su respectivo mensaje
    // TODO: agregar las que hacen falta :)
    @ExceptionHandler({ UserException.class, RoleException.class })
    public ResponseEntity<String> handleCustomExceptions(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Manejo de otras excepciones más generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralExceptions(Exception ex) {
        return new ResponseEntity<>("Error, solicitud no controlada.\n" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
