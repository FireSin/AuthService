package ru.firesin.auth.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.firesin.auth.dto.request.UserDTO;
import ru.firesin.auth.entity.User;
import ru.firesin.auth.exceptions.AuthorizeException;
import ru.firesin.auth.exceptions.UsernamePasswordException;
import ru.firesin.tokens.service.TokenService;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserService userService;
    private final TokenService tokenService;

    public String login(UserDTO userDTO) throws AuthorizeException {
        User user = userService.findUserByName(userDTO);
        if (!PasswordService.checkPassword(userDTO.getPassword(), user.getPassword())) {
            throw new UsernamePasswordException("Wrong username or password");
        }
        return tokenService.generateToken(user.getRole());
    }

    public String registration(UserDTO userDTO) {
        User user = userService.saveNewUser(userDTO);
        return tokenService.generateToken(user.getRole());
    }
}
