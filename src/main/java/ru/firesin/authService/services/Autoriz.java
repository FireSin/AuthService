package ru.firesin.authService.services;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.firesin.authService.annotations.MySecured;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
public class Autoriz {

    Map<String, String> authMap;

    @SneakyThrows
    @GetMapping("/login")
    @MySecured("localUser")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getQueryString());
        response.addHeader("Token", "123456");
    }

    @MySecured("localUser")
    @GetMapping("/entry")
    public String entry(HttpServletRequest request) {
        return "Follow the white rabbit....";
    }
}
