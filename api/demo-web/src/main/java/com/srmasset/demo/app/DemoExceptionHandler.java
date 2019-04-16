package com.srmasset.demo.app;


import com.srmasset.demo.api.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Error> handleMethodArgumentNotValidException(Exception ex, WebRequest req) {
        Error error = new Error("Invalid request");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}