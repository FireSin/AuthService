package ru.firesin.auth.exceptions;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({AuthorizeException.class,
        JWTVerificationException .class})
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleException(UserNotFoundException e) {
        return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(e.getMessage());
    }
}
