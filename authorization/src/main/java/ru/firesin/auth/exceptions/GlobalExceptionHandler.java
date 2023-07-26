package ru.firesin.auth.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorizeException.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(e.getMessage());
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<String> handleException(UserServiceException e) {
        return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(e.getMessage());
    }
}
