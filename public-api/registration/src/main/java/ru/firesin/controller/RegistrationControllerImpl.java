package ru.firesin.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.firesin.dtoUser.request.UserDTO;
import ru.firesin.sevice.RegistrationService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
public class RegistrationControllerImpl implements RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/registration")
    public void registration(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        setCookies(response, registrationService.registration(userDTO));
    }

    private void setCookies(HttpServletResponse response, String jwt){
        Cookie cookie = new Cookie("jwt", jwt);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }
}
