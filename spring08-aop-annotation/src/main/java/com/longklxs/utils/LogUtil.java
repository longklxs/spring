package com.longklxs.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogUtil {

    @Pointcut("execution(* com.longklxs..UserServiceImpl.*(..))")
    public void pointCut(){

    }


    @Before("pointCut()")
    public void beforeLog(){
        System.out.println("方法前增强");
    }

    @AfterReturning("pointCut()")
    public void afterReturn(){
        System.out.println("方法后增强");
    }

    @AfterThrowing("pointCut()")
    public void afterThrows(){
        System.out.println("异常后增强");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("最终增强");
    }
    public Object around(ProceedingJoinPoint pjp){
        try {
            System.out.println("方法前增强");
            Object[] args = pjp.getArgs();
            Object proceed = pjp.proceed(args);
            System.out.println("方法后增强");
            return proceed;
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("异常增强");
            return null;
        }finally {
            System.out.println("最终增强");
        }
    }
}
