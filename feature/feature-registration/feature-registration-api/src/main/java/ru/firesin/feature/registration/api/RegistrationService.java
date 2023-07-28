package ru.firesin.feature.registration.api;

import org.springframework.stereotype.Service;
import ru.firesin.feature.user.app.dtoUser.request.UserDTO;

@Service
public interface RegistrationService {
    String registration(UserDTO userDTO);
}
