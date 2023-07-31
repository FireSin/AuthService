package ru.firesin.tokens.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.firesin.tokens.service.TokenService;

@Configuration
public class TokenServiceConfig {

    @Value("${token.masterKey}")
    private String masterKey;

    @Bean
    public TokenService tokenService(){
        return new TokenService(masterKey);
    }
}
