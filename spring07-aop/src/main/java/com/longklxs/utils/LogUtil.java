package com.longklxs.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogUtil {
    public void beforeLog(){
        System.out.println("方法前增强");
    }

    public void afterReturn(){
        System.out.println("方法后增强");
    }

    public void afterThrows(){
        System.out.println("异常后增强");
    }
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
