# Comparing Spring AOP and AspectJ - Part 1

## AOP Terminology

- **Aspect**: module of code for a cross-cutting concern (logging, security, …)
- **Advice**: What action is taken and when it should be applied
- **Join Point**: When to apply code during program execution
- **Pointcut**: A predicate expression for where advice should be applied

## Advice Types

- **Before advice**: run before the method
- **After finally advice**: run after the method (finally)
- **After returning advice**: run after the method (success execution)
- **After throwing advice**: run after method (if exception thrown)
- **Around advice**: run before and after method

## Weaving

- Connecting aspects to target objects to create an advised object
  - Different types of weaving
- Compile-time, load-time or run-time
- Regarding performance: run-time weaving is the slowest

## AOP Frameworks

Two leading AOP Frameworks for Java

- Spring AOP
- AspectJ

## Spring AOP Support

- Spring provides AOP support
- Key components of Spring actually use Spring AOP
  - Security, transactions, caching etc
- Uses run-time weaving of aspects (proxy pattern)

![spring aop](media/349-1-spring-aop.webp)

## AspectJ

- Original AOP framework, released in 2001
  - https://www.eclipse.org/aspectj
- Provides complete support for AOP

Rich support for

- join points: method-level, constructor, field
- code weaving: compile-time, post compile-time and load-time
