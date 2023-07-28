package ru.firesin.feature.registration.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.firesin.feature.registration.api.RegistrationService;
import ru.firesin.feature.user.app.UserService;
import ru.firesin.feature.user.app.dtoUser.request.UserDTO;
import ru.firesin.feature.user.app.entity.User;
import ru.firesin.feature.user.app.mappers.UserMapper;
import ru.firesin.tokens.service.TokenService;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final TokenService tokenService;
    private final UserMapper userMapper;

    public String registration(UserDTO userDTO) {
        User user = userService.saveNewUser(userDTO);
        return tokenService.generateToken(userMapper.toUserDTO(user));
    }
}
