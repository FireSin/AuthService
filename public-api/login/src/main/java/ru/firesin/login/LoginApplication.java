package ru.firesin.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.firesin.user", "ru.firesin.password", "ru.firesin.login"})
@EnableJpaRepositories(basePackages = "ru.firesin.user.repository")
@EntityScan(basePackages = "ru.firesin.user.entity")
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

}
