package ru.firesin.publicApi.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ru.firesin.feature", "ru.firesin.publicApi.login"})
@EnableJpaRepositories(basePackages = "ru.firesin.feature.user.app.repository")
@EntityScan(basePackages = "ru.firesin.feature.user.app.entity")
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

}
