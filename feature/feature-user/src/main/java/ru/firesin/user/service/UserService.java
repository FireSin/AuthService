package ru.firesin.user.service;

import ru.firesin.user.dtoUser.request.UserDTO;
import ru.firesin.user.entity.User;


public interface UserService {
    User findUser(UserDTO userDTO);
    User saveNewUser(UserDTO user, String role);
    User saveNewUser(UserDTO user);

}
