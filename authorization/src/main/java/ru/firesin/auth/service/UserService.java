package ru.firesin.auth.service;

import ru.firesin.auth.dto.request.UserDTO;
import ru.firesin.auth.entity.User;

public interface UserService {
    User findUser(UserDTO userDTO);
    User saveNewUser(UserDTO user, String role);
    User saveNewUser(UserDTO user);

}
