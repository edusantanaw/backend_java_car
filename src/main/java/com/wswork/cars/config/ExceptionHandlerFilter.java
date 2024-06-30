package com.wswork.cars.config;

import com.wswork.cars.domain.exceptions.DomainException;
import com.wswork.cars.domain.exceptions.EntityValidationException;
import com.wswork.cars.domain.exceptions.NotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerFilter {
    @ExceptionHandler(EntityValidationException.class)
    private ResponseEntity<String> entityValidationException(EntityValidationException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler({NotFoundException.class})
    private ResponseEntity<String> notFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(DomainException.class)
    private ResponseEntity<String> domainException(DomainException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    private ResponseEntity<ValidationException> validatioException(ValidationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }
}
