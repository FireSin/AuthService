package ru.firesin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.firesin.dtoUser.request.UserDTO;
import ru.firesin.entity.User;
import ru.firesin.exceptions.LoginException;
import ru.firesin.mappers.UserMapper;
import ru.firesin.password.service.PasswordService;
import ru.firesin.tokens.service.TokenService;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserService userService;
    private final TokenService tokenService;
    private final UserMapper userMapper;
    private final PasswordService passwordService;

    public String login(UserDTO userDTO) {
        User user = userService.findUser(userDTO);
        if (!passwordService.checkPassword(userDTO.getPassword(), user.getPassword())) {
            throw new LoginException("Wrong username or password");
        }
        return tokenService.generateToken(userMapper.toUserDTO(user));
    }
}
