package ru.firesin.feature.login.api;

import ru.firesin.feature.user.app.dtoUser.request.UserDTO;

public interface LoginService {

    String login(UserDTO userDTO);
}
