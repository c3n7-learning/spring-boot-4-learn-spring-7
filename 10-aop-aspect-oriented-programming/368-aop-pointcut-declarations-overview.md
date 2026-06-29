# AOP: Pointcut Declarations - Overview

## Problem

- How can we reuse a pointcut expression?
  - We want to apply to multiple advices

```java
// I wan to reuse this pointcut expression
@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
public void beforeAddAccountAdvice() {
  // ...
}
```

## Possible Solution

- Could just do the old copy/paste method … yuk!

```java
// I wan to reuse this pointcut expression
@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
public void beforeAddAccountAdvice() {
  // ...
}

@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
public void performApiAnalytics() {
  // ...
}
```

## Ideal Solution

- Create a pointcut declaration once
- Apply it to multiple advices

## Development Process

1. Create a pointcut declaration
2. Apply pointcut declaration to advice(s)

## Step 1 - Create a pointcut declaration once

Create a pointcut declaration once

```java
@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))") // Pointcut Expression
private void forDaoPackage() {}                            // Name of pointcut expression
```

Bigger Picture:

```java
@Aspect
@Component
public class MyDemoLoggingAspect {

  @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))") // Pointcut Expression
  private void forDaoPackage() {}                            // Name of pointcut expression

}
```

## Step 2 - Apply to Multiple Advices

```java
@Aspect
@Component
public class MyDemoLoggingAspect {

  @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
  private void forDaoPackage() {}

  @Before("forDaoPackage()")
  public void beforeAddAccountAdvice() {
    // …
  }

  @Before("forDaoPackage()")
  public void performApiAnalytics() {
    // …
  }
}
```

## Benefits of Pointcut Declarations

- Easily reuse pointcut expressions
- Update pointcut in one location
- Can also share and combine pointcut expressions (coming up later)
