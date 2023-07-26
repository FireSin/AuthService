package ru.firesin.auth.controller;

import org.springframework.web.bind.annotation.RequestBody;
import ru.firesin.auth.dto.request.UserDTO;

import javax.servlet.http.HttpServletResponse;

public interface AuthController {

    void login(@RequestBody UserDTO userDTO, HttpServletResponse response);

    void registration(@RequestBody UserDTO userDTO, HttpServletResponse response);
}
