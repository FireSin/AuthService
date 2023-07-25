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
import ru.firesin.tokens.dto.TokenUserDTO;
import ru.firesin.tokens.service.TokenService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@AllArgsConstructor
public class MySecuredAspect { //TODO Не вижу обработчика твоих ошибок в этой либе, те мне придётся в каждом модуле свой писать постоянно?

    private final TokenService tokenService;

    @Around("@annotation(mySecured)")
    public Object secured(ProceedingJoinPoint joinPoint, MySecured mySecured) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        TokenUserDTO tokenUserDTO;
        try {
            Cookie cookie = WebUtils.getCookie(request, "jwt");
            tokenUserDTO = tokenService.deserializationToken(cookie.getValue());
        } catch (Exception e){
            throw new JWTVerificationException("You have no path"); //TODO А че тут написано, что такое path?
        }
        if (!tokenUserDTO.getRole().equals(mySecured.value())){
            throw new JWTVerificationException("You have no path"); //TODO А почему ошибка та же? В 1ом случае у тебя не прочитался JWT, а тут нет прав
        }
        return joinPoint.proceed();
    }
}
