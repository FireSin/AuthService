package ru.firesin.auth.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorizeException.class)
    public ResponseEntity<String> handleException(AuthorizeException e) {
        return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(e.getMessage());
    }

    @ExceptionHandler(UsernamePasswordException.class)
    public ResponseEntity<String> handleException(UsernamePasswordException e) {
        return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleException(UserNotFoundException e) {
        return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(e.getMessage());
    }
}
