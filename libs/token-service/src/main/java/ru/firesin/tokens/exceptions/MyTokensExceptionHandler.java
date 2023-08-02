package ru.firesin.tokens.exceptions;

import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@NoArgsConstructor
public class MyTokensExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(e.getMessage());
    }
}
