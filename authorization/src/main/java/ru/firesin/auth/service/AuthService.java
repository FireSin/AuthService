package ru.firesin.auth.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import ru.firesin.auth.dto.request.UserDTO;
import ru.firesin.auth.entity.User;
import ru.firesin.auth.repository.UserRepository;
import ru.firesin.tokens.service.TokenService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Component
@Data
@AllArgsConstructor
public class AuthService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final TokenService tokenService;

    public String authorize(UserDTO userDTO, HttpServletResponse response){
        User user = userRepository.findByName(userDTO.getName());
        if (user == null){
            return registerUser(userDTO, response);
        }
        if (PasswordService.checkPassword(userDTO.getPassword(), user.getPassword())){
            HttpHeaders headers = new HttpHeaders();
            String jwt = user.getToken();
            Cookie cookie = new Cookie("jwt", jwt);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            return "Login success";
        }
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return "Bad login or password";
    }

    private String registerUser(UserDTO userDTO, HttpServletResponse response){
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(PasswordService.hashPassword(userDTO.getPassword()));
        user.setRole("localUser");
        user.setToken(tokenService.generateToken(user.getRole()));
        userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        String jwt = user.getToken();
        Cookie cookie = new Cookie("jwt", jwt);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return "Register success";
    }
}
