package ru.firesin.login.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.firesin.login.service.LoginService;
import ru.firesin.user.dtoUser.request.UserDTO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public void login(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        setCookies(response, loginService.login(userDTO));
    }

    private void setCookies(HttpServletResponse response, String jwt){
        Cookie cookie = new Cookie("jwt", jwt);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }
}