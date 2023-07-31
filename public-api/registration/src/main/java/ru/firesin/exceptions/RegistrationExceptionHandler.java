package ru.firesin.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@NoArgsConstructor
public class RegistrationExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(e.getMessage());
    }
}
