package ru.firesin.registration.service;

import ru.firesin.user.dtoUser.request.UserDTO;

public interface RegistrationService {
    String registration(UserDTO userDTO);
}
