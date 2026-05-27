# Spring Boot REST Controller - Overview - Part 2

## Development Process

1. Add Maven dependency for Spring Boot Starter Web
2. Create Spring REST Service using `@RestController`

## Step 1: Add Maven Dependency

- At Spring Initializr website, we can also select the “Web” dependency
- In `pom.xml`

```xml
<!-- Add Spring Boot Starter Web MVC -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>
```

## Step 2: Create Spring REST Service

```java
@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

}
```
