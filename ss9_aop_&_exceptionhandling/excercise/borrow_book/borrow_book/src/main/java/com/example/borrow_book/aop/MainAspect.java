package com.example.borrow_book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MainAspect {
    private long numberOfRequestsToServer = 0;

    @Pointcut("within(com.example.borrow_book.controller.*)")
    public void countNumberOfRequestsToServer() {
    }

    @Before("countNumberOfRequestsToServer()")
    public void beforeCountNumberOfClientsHandler(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        this.numberOfRequestsToServer++;
        System.out.println("The number request to server: " + this.numberOfRequestsToServer);
    }
}
