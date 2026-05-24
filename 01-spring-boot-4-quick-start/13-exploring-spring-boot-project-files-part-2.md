# Exploring Spring Boot Project Files - Part 2

## Application Properties

### Introduction

- By default, Spring Boot will load properties from: `application.properties`
  - `src/main/resources/application.properties`
- Can add Spring Boot properties: `server.port=8585`
- Also add your own custom properties `coach.name=Mickey Mouse`

### How to Read data from `application.properties`

- Assume we have:

```
# configure server port
server.port=8484

# configure my props
coach.name=Mickey Mouse
team.name=The Mouse Crew
```

- We can access it like:

```java
@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    ...
}
```

## Static Content

- By default, Spring Boot will load static resources from "/static" directory
  - `src/main/resources/static`
- Examples of static resources HTML files, CSS, JavaScript, images, etc …

> ⚠️WARNING⚠️:  
> Do not use the src/main/webapp directory if your application is packaged as a JAR.  
> Although this is a standard Maven directory, it works only with WAR packaging.  
> It is silently ignored by most build tools if you generate a JAR.

### Templates

- `src/main/resources/templates`
- Spring Boot includes auto-configuration for following template engines
  - FreeMarker
  - Thymeleaf
  - Mustache
- By default, Spring Boot will load templates from "/templates" directory

## Unit Tests

- `src/test`
- Contains Spring Boot unit test class Created by Spring Initializr
- You can add unit tests to the file
