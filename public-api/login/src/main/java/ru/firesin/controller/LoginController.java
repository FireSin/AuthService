package ru.firesin.controller;

import org.springframework.stereotype.Component;
import ru.firesin.dtoUser.request.UserDTO;

import javax.servlet.http.HttpServletResponse;

@Component
public interface LoginController {
    void login(UserDTO userDTO, HttpServletResponse response);
}
