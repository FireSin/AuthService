package ru.firesin.registration.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.firesin.user.dtoUser.request.UserDTO;
import ru.firesin.user.entity.User;
import ru.firesin.user.mappers.UserMapper;
import ru.firesin.user.service.UserService;
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
