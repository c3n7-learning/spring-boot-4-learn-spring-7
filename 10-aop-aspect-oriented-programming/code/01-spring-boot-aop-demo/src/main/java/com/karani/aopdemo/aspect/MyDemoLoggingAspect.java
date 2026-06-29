package com.karani.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // Match any addSillyMember() Method
    // @Before("execution(public void addSillyMember())")

    // Match only AccountDAO.addSillyMember
    // @Before("execution(public void com.karani.aopdemo.dao.AccountDAO.addSillyMember())")

    // Match any `add*` Method
    // @Before("execution(public void add*())")

    //  Match any Return Type
    // @Before("execution(* add*())")

    // Match on a specific param
    // @Before("execution(* add*(com.karani.aopdemo.Account))")

    // Match Method with Account and more Params
    @Before("execution(* add*(com.karani.aopdemo.Account, ..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> Executing @Before advice on method");
    }
}
