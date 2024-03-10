package com.java.simplesocialmediaapp.restfulwebservices.exception;

import com.java.simplesocialmediaapp.restfulwebservices.user.UserNotFoundException;
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

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorMessage> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getFieldErrors().toString(), request.getDescription(false) );
        return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }

    }
