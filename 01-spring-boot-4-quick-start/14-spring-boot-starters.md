# Spring Boot Starters

## The Problem

- Building a Spring application is really HARD!!!
- FAQ: Which Maven dependencies do I need?
- FAQ: How do i know which dependency works with package X?

## Why Is It So Hard?

- It would be great if there was a simple list of Maven dependencies
- Collected as a group of dependencies … one-stop shop
- So I don't have to search for each dependency

There should be an easier solution

## The Solution - Spring Boot Starters

- Spring Boot Starters
- A curated list of Maven dependencies
- A collection of dependencies grouped together
- Tested and verified by the Spring Development team
- Makes it much easier for the developer to get started with Spring
- Reduces the amount of Maven configuration

### Example Problem: Spring MVC

- For example, when building a Spring MVC app, you normally need

```xml
<!-- Spring support -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>7.0.0</version>
</dependency>

<!-- Hibernate Validator -->
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>9.1.0.Final</version>
</dependency>

<!-- Web template: Thymeleaf -->
<dependency>
    <groupId>org.thymeleaf</groupId>
    <artifactId>thymeleaf-spring6</artifactId>
    <version>3.1.3.RELEASE</version>
</dependency>
```

### Solution: Spring Boot Starter - Web MVC

- Spring Boot provides: `spring-boot-starter-webmvc`

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>
```

### Spring MVC: Spring Initializr

- In Spring Initializr, simply select Web dependency
- You automatically get `spring-boot-starter-webmvc` in `pom.xml`

## Spring Initializr

- If we are building a Spring app that needs: Web, Security, …
- Simply select the dependencies in the Spring Initializr
- It will add the appropriate Spring Boot starters to your `pom.xml`

## Spring Boot Starters

- There are 70+ Spring Boot Starters from the Spring Development team

| Name                         | Description                                                              |
| ---------------------------- | ------------------------------------------------------------------------ |
| spring-boot-starter-webmvc   | Building web apps, includes REST. Uses Tomcat as default embedded server |
| spring-boot-starter-security | Adding Spring Security support                                           |
| spring-boot-starter-data-jpa | Spring database support with JPA and Hibernate                           |
| ...                          |                                                                          |

- https://docs.spring.io/spring-boot/reference/using/build-systems.html#using.build-systems.starters

## What Is In the Starter?

FAQ: What is in spring-boot-starter-xyz?

- View the starter's POM file
  - Normally references other starters … so you will need to dig a bit
  - Somewhat cumbersome …

Most IDEs have a Dependency Management / View feature

- Much easier to navigate
- I'll show you how to do this with Eclipse and IntelliJ

For Eclipse Users

- Open the pom.xml
- Select the tab **Dependency Hierarchy**
- Expand the desired starter

For IntelliJ users

- Select View > Tool Windows > Maven Projects > Dependencies
