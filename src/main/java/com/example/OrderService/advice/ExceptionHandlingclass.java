package com.example.OrderService.advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionHandlingclass {


    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,String> errorshandling(ConstraintViolationException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getConstraintViolations().forEach(error -> {

        errors.put(error.getPropertyPath().toString(),error.getMessage());

    });

return errors;
}


}
