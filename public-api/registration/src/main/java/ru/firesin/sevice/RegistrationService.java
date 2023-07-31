package ru.firesin.sevice;

import org.springframework.stereotype.Service;
import ru.firesin.dtoUser.request.UserDTO;

@Service
public interface RegistrationService {
    String registration(UserDTO userDTO);
}
