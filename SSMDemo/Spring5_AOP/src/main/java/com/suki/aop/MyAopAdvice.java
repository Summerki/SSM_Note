package com.suki.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAopAdvice {


    public void log(JoinPoint pjp){
        System.out.println("我要记录下日志");
        System.out.println( pjp.getSignature().getName());// 方法名
        System.out.println(Arrays.toString(pjp.getArgs()));// 获取参数们
    }

    public void after(){
        System.out.println("测试后置通知");
    }

    public void afterReturning(){
        System.out.println("测试afterReturning");
    }

}
