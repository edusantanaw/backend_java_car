package com.wswork.cars.config;

import com.wswork.cars.domain.exceptions.EntityValidationException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandlerFilter {
    @ExceptionHandler(EntityValidationException.class)
    private ResponseEntity<String> entityValidationException(EntityValidationException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    private ResponseEntity<ValidationException> validatioException(ValidationException exception) {
        return ResponseEntity.status(400).body(exception);
    }
}
