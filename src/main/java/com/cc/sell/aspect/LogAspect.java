package com.cc.sell.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author chencheng
 * @date 2019/4/25
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.cc.sell.annotation.Log)")
    public void logPointCut(){

    }


    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        Object result=point.proceed();
        return result;
    }
}
