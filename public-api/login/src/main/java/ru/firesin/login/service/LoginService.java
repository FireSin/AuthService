package ru.firesin.login.service;

import ru.firesin.user.dtoUser.request.UserDTO;

public interface LoginService {

    String login(UserDTO userDTO);
}
