package ru.firesin.registration;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.firesin.user", "ru.firesin.password", "ru.firesin.registration"})
@EnableJpaRepositories(basePackages = "ru.firesin.user.repository")
@EntityScan(basePackages = "ru.firesin.user.entity")
public class RegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
