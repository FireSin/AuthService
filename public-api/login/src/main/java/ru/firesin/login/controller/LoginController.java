package ru.firesin.login.controller;

import ru.firesin.user.dtoUser.request.UserDTO;
import javax.servlet.http.HttpServletResponse;

public interface LoginController {
    void login(UserDTO userDTO, HttpServletResponse response);
}
