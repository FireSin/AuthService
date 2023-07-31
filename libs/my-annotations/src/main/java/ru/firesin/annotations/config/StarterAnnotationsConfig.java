package ru.firesin.annotations.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.firesin.annotations.aspect.MySecuredAspect;
import ru.firesin.annotations.exceptions.MyAnnotationsExceptionHandler;
import ru.firesin.tokens.service.TokenService;

@Configuration
public class StarterAnnotationsConfig{

    @Autowired
    private TokenService tokenService;

    @Bean
    public MyAnnotationsExceptionHandler globalExceptionHandler(){
        return new MyAnnotationsExceptionHandler();
    }

    @Bean
    public MySecuredAspect roleFilter(){
        return new MySecuredAspect(tokenService);
    }
}
