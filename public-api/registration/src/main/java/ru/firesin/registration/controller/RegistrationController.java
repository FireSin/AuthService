package ru.firesin.registration.controller;

import ru.firesin.user.dtoUser.request.UserDTO;
import javax.servlet.http.HttpServletResponse;

public interface RegistrationController {
    void registration(UserDTO userDTO, HttpServletResponse response);
}
