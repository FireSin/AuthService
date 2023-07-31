package ru.firesin.service;

import org.springframework.stereotype.Service;
import ru.firesin.dtoUser.request.UserDTO;
import ru.firesin.entity.User;


@Service
public interface UserService {
    User findUser(UserDTO userDTO);
    User saveNewUser(UserDTO user, String role);
    User saveNewUser(UserDTO user);

}
