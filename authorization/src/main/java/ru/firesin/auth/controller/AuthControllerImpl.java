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
public class AuthControllerImpl implements AuthController{

    private final AuthService authService;

    @PostMapping("/login")
    public void login(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        setCookies(response, authService.login(userDTO));
    }

    @PostMapping("/registration")
    public void registration(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        setCookies(response, authService.registration(userDTO));
    }

    private void setCookies(HttpServletResponse response, String jwt){
        Cookie cookie = new Cookie("jwt", jwt);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }
}

