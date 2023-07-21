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
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public void login(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        String jwt = authService.login(userDTO);
        Cookie cookie = new Cookie("jwt", jwt);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }

    @PostMapping("/registration")
    public void registration(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        String jwt = authService.registration(userDTO);
        Cookie cookie = new Cookie("jwt", jwt);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }
}

