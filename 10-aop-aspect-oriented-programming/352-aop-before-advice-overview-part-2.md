# AOP - @Befor Advice - Overview - Part 2

## Spring Boot AOP Starter (aspectj)

- Add the dependency for Spring Boot AOP Starter (aspectj)

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-aspectj</artifactId>
</dependency>
```

Since this dependency is part of our `pom.xml`:

- Spring Boot will automatically enable support for AOP
- No need to explicitly use @EnableAspectJAutoProxy … we get it for free
  - in old and legacy non-spring boot projects, we had to do this

## Development Process - @Before

1. Create target object: `AccountDAO`
2. Create main app
3. Create an Aspect with `@Before` advice

## Step 1: Create Target Object: AccountDAO

```java
public interface AccountDAO {
  void addAccount() {
}
```

```java
@Component
public class AccountDAOImpl implements AccountDAO {
  public void addAccount() {
    System.out.println("DOING MY DB WORK: ADDING AN ACCOUNT");
  }
}
```

## Step 2: Create main app

```java
@SpringBootApplication
public class AopdemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(AopdemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
    return runner -> {
      demoTheBeforeAdvice(theAccountDAO);
    };
  }

  private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {
    // call the business method
    theAccountDAO.addAccount();
  }
}
```

## Step 3: Create an Aspect with @Before advice

```java
@Aspect
@Component
public class MyDemoLoggingAspect {
  @Before("execution(public void addAccount())") // Pointcut expression
  public void beforeAddAccountAdvice() {
    System.out.println("Executing @Before advice on addAccount()");
  }
}
```

## Best Practices: Aspect and Advices

- Keep the code small
- Keep the code fast
- Do not perform any expensive / slow operations
- Get in and out as QUICKLY as possible
