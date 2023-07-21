package ru.firesin.auth.service;

import ru.firesin.auth.dto.request.UserDTO;

public interface AuthService {
    String login(UserDTO userDTO);

    String registration(UserDTO userDTO);
}
