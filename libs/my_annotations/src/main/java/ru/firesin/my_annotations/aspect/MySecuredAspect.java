package ru.firesin.my_annotations.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.firesin.my_annotations.secured.MySecured;
import ru.firesin.tokens.service.TokenService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class MySecuredAspect {
    @Autowired
    TokenService tokenService;

    @Around("@annotation(mySecured)")
    public Object secured(ProceedingJoinPoint joinPoint, MySecured mySecured) throws Throwable {
        var args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (var cookie:cookies){
                if (cookie.getName().equals("jwt") && tokenService.checkToken(cookie.getValue(), mySecured.value())){
                    return joinPoint.proceed();
                }
            }
        }
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write("Unauthorezed");
        response.getWriter().flush();
        response.getWriter().close();
        return null;
    }
}
