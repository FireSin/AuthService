package ru.firesin.my_annotations.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.firesin.my_annotations.secured.MySecured;

@Aspect
@Component
public class MySecuredAspect {

    @Before("@annotation(mySecured)")
    public void secured(JoinPoint joinPoint, MySecured mySecured){
        System.out.println(mySecured.value()[0]);
    }
}
