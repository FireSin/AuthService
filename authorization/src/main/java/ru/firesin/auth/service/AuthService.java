package ru.firesin.auth.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.firesin.auth.dto.request.UserDTO;
import ru.firesin.auth.entity.User;
import ru.firesin.auth.repository.UserRepository;

import java.security.SecureRandom;
import java.util.Base64;

@Component
@Data
@NoArgsConstructor
public class AuthService {
    private static final String MASTER_PASSWORD = "WhiteRabbit";
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> authorize(UserDTO userDTO){
        User user = userRepository.findByName(userDTO.getName());
        if (user == null){
            return registerUser(userDTO);
        }
        if (user.getPassword().equals(userDTO.getPassword())){
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + user.getToken());
            return ResponseEntity.ok().headers(headers).body("Login success");
        }
        return ResponseEntity.ok("False username or password");
    }

    private ResponseEntity<String> registerUser(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setRole("localUser");
        user.setToken("QT1");
        userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + user.getToken());
        return ResponseEntity.ok().headers(headers).body("Registry success");
    }
}
