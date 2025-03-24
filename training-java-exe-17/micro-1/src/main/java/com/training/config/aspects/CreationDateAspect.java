package com.training.config.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;


@Aspect
@Slf4j
@Component
public class CreationDateAspect {

    @Pointcut("execution(* com.training.content..*RepositoryJpa.save(..))")
    public void addCreationDateJpa() { }

    @Before("addCreationDateJpa()")
    public void beforeAdvice(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            try {
                Class<?> clazz = arg.getClass();

                Method setCreationDateMethod = clazz.getMethod("setCreationDate", LocalDateTime.class);

                setCreationDateMethod.invoke(arg, LocalDateTime.now());
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {

                e.printStackTrace();
            }
        }

    }

}
