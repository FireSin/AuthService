package ru.firesin.feature.registration.api;

import ru.firesin.feature.user.app.dtoUser.request.UserDTO;

public interface RegistrationService {
    String registration(UserDTO userDTO);
}
