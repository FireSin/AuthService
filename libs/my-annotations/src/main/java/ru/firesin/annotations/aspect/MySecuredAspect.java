package ru.firesin.annotations.aspect;

import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;
import ru.firesin.annotations.secured.MySecured;
import ru.firesin.tokens.dto.TokenDTO;
import ru.firesin.tokens.service.TokenService;

import java.lang.reflect.Field;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@AllArgsConstructor
public class MySecuredAspect {

    private final TokenService tokenService;

    @Around("@annotation(mySecured)")
    public Object secured(ProceedingJoinPoint joinPoint, MySecured mySecured) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        TokenDTO tokenDTO;
        try {
            Cookie cookie = WebUtils.getCookie(request, "jwt");
            tokenDTO = tokenService.deserializationToken(cookie.getValue());
        } catch (Exception e){
            throw new JWTVerificationException("Incorrect token");
        }

        Field[] fields = tokenDTO.getClass().getDeclaredFields();
        if (mySecured.value().length != fields.length){
            throw new JWTVerificationException("You don't have access rights");
        }
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            if (!fields[i].get(tokenDTO).toString().equals(mySecured.value()[i])){
                fields[i].setAccessible(false);
                throw new JWTVerificationException("You don't have access rights");
            }
            fields[i].setAccessible(false);
        }
        return joinPoint.proceed();
    }
}
