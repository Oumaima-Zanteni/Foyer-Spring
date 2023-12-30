package com.example.foyerspring.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
// classe aspect
@Component
@Aspect
@Slf4j
public class FoyerAspect {
    // methode : advice
    @Before("execution(* com.example.foyerspring.Services.*.*(..))")
    public void method(JoinPoint jp) {
        log.info("hello" + jp.getSignature().getName());
    }

    @After("execution(* com.example.foyerspring.Services.*.*(..))")
    public void method( ){
        log.info("Bye");
    }

    /*@Around("execution(* com.example.foyerspring.Services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable
    {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis()-start;
        log.info("Method execution time : "+ elapsedTime +"milliseconds.");
        return null;
    }*/
}