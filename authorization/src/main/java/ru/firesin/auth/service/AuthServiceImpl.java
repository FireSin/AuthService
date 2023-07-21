package ru.firesin.auth.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.firesin.auth.dto.request.UserDTO;
import ru.firesin.auth.entity.User;
import ru.firesin.auth.exceptions.AuthorizeException;
import ru.firesin.auth.repository.UserRepository;
import ru.firesin.tokens.service.TokenService;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final TokenService tokenService;

    public String authorize(UserDTO userDTO) throws AuthorizeException {
        User user = userRepository.findByName(userDTO.getName());
        if (user == null){
            user = new User();
            user.setName(userDTO.getName());
            user.setPassword(PasswordService.hashPassword(userDTO.getPassword()));
            user.setRole("localUser");
            userRepository.save(user);
        } else if (!PasswordService.checkPassword(userDTO.getPassword(), user.getPassword())) {
            throw new AuthorizeException("Bad login or password");
        }
        return tokenService.generateToken(user.getRole());
    }
}
