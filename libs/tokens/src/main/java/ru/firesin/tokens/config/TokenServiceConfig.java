package ru.firesin.tokens.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.firesin.tokens.service.TokenService;

@Configuration
@PropertySource("classpath:application.properties") //TODO Посмотри как еще можно делать
public class TokenServiceConfig {
    @Value("${masterKey}")
    private String masterKey;

    @Bean
    public TokenService tokenService(){
        return new TokenService(masterKey);
    }
}
