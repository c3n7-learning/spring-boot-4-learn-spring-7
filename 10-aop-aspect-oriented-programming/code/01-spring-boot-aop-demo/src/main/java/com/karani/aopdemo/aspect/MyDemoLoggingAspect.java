package com.karani.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // Match any addAccount() Method
    // @Before("execution(public void addAccount())")

    // Match only AccountDAO.addAccount
    @Before("execution(public void com.karani.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> Executing @Before on addAccount()");
    }
}
