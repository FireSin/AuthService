package ru.firesin.feature.user.app;

import ru.firesin.feature.user.app.dtoUser.request.UserDTO;
import ru.firesin.feature.user.app.entity.User;

public interface UserService {
    User findUser(UserDTO userDTO);
    User saveNewUser(UserDTO user, String role);
    User saveNewUser(UserDTO user);

}
