package ru.firesin.authService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.firesin.authService.annotations.MySecured;
import ru.firesin.authService.bd.AuthUser;
import ru.firesin.authService.dto_entry.UserJson;
import ru.firesin.authService.repository.UserRepository;

import java.security.SecureRandom;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class Autoriz {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserJson userJson) {
        AuthUser authUser = new AuthUser();
        authUser.setName(userJson.getName());
        authUser.setPassword(userJson.getPassword());
        authUser.setRole("localUser");
        authUser.setToken(generateToken());
        try {
            userRepository.save(authUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + authUser.getToken()); // Добавляем токен в заголовок
        return ResponseEntity.ok().headers(headers).body("Success");
    }

    private String generateToken() {
        byte[] randomBytes = new byte[32];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    @GetMapping("/entry")
    @MySecured("localUser")
    public String entry(HttpServletRequest request) {
        String token = request.getHeader("Token");
        var user = userRepository.findByToken(token);
        try {
            return "Follow the white rabbit. \nKnock, knock, " + user.getName();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
