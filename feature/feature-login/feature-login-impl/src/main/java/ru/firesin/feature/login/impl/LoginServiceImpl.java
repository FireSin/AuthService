package ru.firesin.feature.login.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.firesin.feature.login.api.LoginService;
import ru.firesin.feature.login.impl.exceptions.LoginException;
import ru.firesin.feature.password.api.PasswordService;
import ru.firesin.feature.user.app.UserService;
import ru.firesin.feature.user.app.dtoUser.request.UserDTO;
import ru.firesin.feature.user.app.entity.User;
import ru.firesin.feature.user.app.mappers.UserMapper;
import ru.firesin.tokens.service.TokenService;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserService userService;
    private final TokenService tokenService;
    private final UserMapper userMapper;
    private final PasswordService passwordSevice;

    public String login(UserDTO userDTO) {
        User user = userService.findUser(userDTO);
        if (!passwordSevice.checkPassword(userDTO.getPassword(), user.getPassword())) {
            throw new LoginException("Wrong username or password");
        }
        return tokenService.generateToken(userMapper.toUserDTO(user));
    }
}
