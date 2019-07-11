package com.java.fibonacci.service;

import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Aspect
public class Time {

    private static long recursivebeginTime;
    private static long recursiveendTime;
    private static long iterativebeginTime;
    private static long iterativeendTime;
    private static long fastbeginTime;
    private static long fastendTime;

    public long recursiveTime() {
        long time = recursiveendTime - recursivebeginTime;
        return time;
    }

    public long iterativeTime() {
        long time = iterativeendTime - iterativebeginTime;
        return time;
    }

    public long fastTime() {
        long time = fastendTime - fastbeginTime;
        return time;
    }

    @Before("execution(* com.java.fibonacci.service.FastFibonacci.computeFib(..))")
    private long fastBeginTime() {
        fastbeginTime = System.currentTimeMillis();
        return fastbeginTime;
    }

    @After("execution(* com.java.fibonacci.service.FastFibonacci.computeFib(..))")
    private long fastEndTime()  {
        fastendTime = System.currentTimeMillis();
        return fastendTime;
    }

    @Before("execution(* com.java.fibonacci.service.IterativeFibonacci.computeFib(..))")
    private long iterativeBeginTime() {
        iterativebeginTime = System.currentTimeMillis();
        return iterativebeginTime;
    }

    @After("execution(* com.java.fibonacci.service.IterativeFibonacci.computeFib(..))")
    private long iterativeEndTime()  {
        iterativeendTime = System.currentTimeMillis();
        return iterativeendTime;
    }


    @Before("execution(* com.java.fibonacci.service.RecursiveFibonacci.computeFib(..))")
    private long recursiveBeginTime() {
        recursivebeginTime = System.currentTimeMillis();
        return recursivebeginTime;
    }

    @After("execution(* com.java.fibonacci.service.RecursiveFibonacci.computeFib(..))")
    private long recursiveEndTime()  {
        recursiveendTime = System.currentTimeMillis();
        return recursiveendTime;
    }
}
