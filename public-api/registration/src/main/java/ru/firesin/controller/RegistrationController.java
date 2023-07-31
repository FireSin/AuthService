package ru.firesin.controller;

import org.springframework.stereotype.Component;
import ru.firesin.dtoUser.request.UserDTO;

import javax.servlet.http.HttpServletResponse;

@Component
public interface RegistrationController {
    void registration(UserDTO userDTO, HttpServletResponse response);
}
