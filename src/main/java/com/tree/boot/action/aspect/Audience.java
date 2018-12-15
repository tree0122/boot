package com.tree.boot.action.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Audience {

    @Pointcut("execution(**aspect.service.Perfomance.perform(..))")
    public void performance(){
    }

    @Before("performance()")
    public void silenceCellPhone(){
        System.out.println("Silencing cell phone");
    }

    @Before("performance()")
    public void takeSeat(){
        System.out.println("Take seat");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

}
