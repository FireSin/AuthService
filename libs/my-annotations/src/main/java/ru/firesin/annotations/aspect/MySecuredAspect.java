package ru.firesin.annotations.aspect;

import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;
import ru.firesin.annotations.secured.MySecured;
import ru.firesin.tokens.service.TokenService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
@AllArgsConstructor
public class MySecuredAspect {

    private final TokenService tokenService;

    @Around("@annotation(mySecured)")
    public Object secured(ProceedingJoinPoint joinPoint, MySecured mySecured) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        try {
            Cookie cookie = WebUtils.getCookie(request, "jwt");
            tokenService.checkToken(cookie.getValue(), mySecured.value());
            return joinPoint.proceed();
        } catch (Exception e){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
        return null;
    }
}
