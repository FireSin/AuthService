package ru.firesin.auth.service;

import ru.firesin.auth.dto.request.UserDTO;

import javax.servlet.http.Cookie;

public interface AuthService {
    public Cookie authorize(UserDTO userDTO);
}
