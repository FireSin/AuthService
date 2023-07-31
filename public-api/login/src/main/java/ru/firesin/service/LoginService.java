package ru.firesin.service;

import org.springframework.stereotype.Service;
import ru.firesin.dtoUser.request.UserDTO;

@Service
public interface LoginService {

    String login(UserDTO userDTO);
}
