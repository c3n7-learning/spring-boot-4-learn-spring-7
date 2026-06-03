# Spring MVC Security - Project Set Up - Part 1

## Development Process

1. Create project at Spring Initializr website
   1. Add Maven dependencies for Spring MVC Web App, Security, Thymeleaf
2. Develop our Spring controller
3. Develop our Thymeleaf view page

## Step 1: Add Maven dependencies for Spring MVC Web App

`pom.xml`:

```xml
<!-- Spring MVC web support-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>

<!-- Thymeleaf view support-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<!-- Spring Security support -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- Thymeleaf Security support -->
<dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-springsecurity6</artifactId>
</dependency>
```

## Step 2: Develop our Spring Controller

`DemoController.java`:

```java
@Controller
public class DemoController {
  @GetMapping("/")
  public String showHome() {
    return "home";
    View name View name
  }
}
```

## Step 3: Develop our Thymeleaf view page

```html
<html>
  <body>
    Welcome to the luv2code company home page!
  </body>
</html>
```

## Get Fresh Web Session

Option 1:

- Start new web browser

Option 2:

- In web browser and open new Private / Incognito window

## Hands On

- `08-spring-mvc-security/code/01-spring-boot-mvc-security-default`
