package ru.firesin.my_annotations.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.firesin.my_annotations.aspect.MySecuredAspect;
import ru.firesin.tokens.service.TokenService;

@Configuration
public class StarterAnnotationsConfig {

    @Bean
    public MySecuredAspect roleFilter(){
        return new MySecuredAspect();
    }
}
