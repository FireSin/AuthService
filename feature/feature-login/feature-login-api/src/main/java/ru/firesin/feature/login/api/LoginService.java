package ru.firesin.feature.login.api;

import org.springframework.stereotype.Service;
import ru.firesin.feature.user.app.dtoUser.request.UserDTO;

@Service
public interface LoginService {

    String login(UserDTO userDTO);
}
