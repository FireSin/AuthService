package ru.firesin.auth.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.firesin.auth.dto.request.UserDTO;
import ru.firesin.auth.entity.User;
import ru.firesin.auth.repository.UserRepository;
import ru.firesin.auth.service.AuthService;

import java.security.SecureRandom;
import java.util.Base64;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
@AllArgsConstructor
public class LoginController {

    @Autowired
    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        return authService.authorize(userDTO, response);
    }
}

