package ru.firesin.auth.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.firesin.auth.dto.request.UserDTO;
import ru.firesin.auth.service.AuthService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
public class LoginController {

    private final AuthService authService;

    @PostMapping("/login")
    public void login(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        try {
            Cookie cookie = authService.authorize(userDTO);
            response.addCookie(cookie);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}

