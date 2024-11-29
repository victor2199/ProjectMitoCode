package com.mitocode.servicesrest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalErrorHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleExceptionGeneral(Exception ex, WebRequest request) {
        CustomErrorResponse error = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        CustomErrorResponse error = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {

        String message = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getField() + " : " + error.getDefaultMessage()).collect(Collectors.joining( ","));
        CustomErrorResponse error = new CustomErrorResponse(LocalDateTime.now(), message, request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    */

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getField() + " : " + error.getDefaultMessage()).collect(Collectors.joining( ","));
        CustomErrorResponse error = new CustomErrorResponse(LocalDateTime.now(), message, request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
