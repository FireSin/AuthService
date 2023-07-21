package ru.firesin.auth.service;

import ru.firesin.auth.dto.request.UserDTO;

public interface AuthService {
    public String authorize(UserDTO userDTO);
}
