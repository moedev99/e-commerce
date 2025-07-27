package com.moedev99.ecommerce;

import com.moedev99.ecommerce.exception.ErrorResponse;
import com.moedev99.ecommerce.exception.FileValidityException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({FileValidityException.class})
    public ResponseEntity<Object> fileValidityException(RuntimeException e){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), List.of(e.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
