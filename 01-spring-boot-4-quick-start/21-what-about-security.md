# What about security?

You may NOT want to expose all of this information

```
{
  "contexts": {
    "application": {
      "beans": {
        "endpointCachingOperationInvokerAdvisor": {
          "aliases": [],
          "scope": "singleton",
          "type": "org.springframework.boot.actuate.endpoint.invoker.cache.CachingOperationInvokerAdvisor",
          "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/servlet/WebMvcEndpointManagementContextConfiguration$WebMvcEndpointManagementConfiguration.class]",
          "dependencies": [],
          "environment"
        }
      },
      "defaultServletHandlerMapping": {
        "aliases": [],
        "scope": "singleton",
        "type": "org.springframework.web.servlet.HandlerMapping",
        "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
        "dependencies": []
      },
      "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration": {
        "aliases": [],
        "scope": "singleton",
        "type":
```

Add Spring Security to project and endpoints are secured :-)

- `/health` is still available. You can disable it if you want.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

## Secured Endpoints

- Now when you access: `/actuator/beans`
- Spring Security will prompt for login
  - Default user name: `user`
  - Check console logs for password

## Spring Security configuration

- You can override default user name and generated password

File: `src/main/resources/application.properties`:

```
spring.security.user.name=scott
spring.security.user.password=tiger
```

## Customizing Spring Security

- You can customize Spring Security for Spring Boot Actuator
- Use a database for roles, encrypted passwords etc …
- We will cover details of Spring Security later in the course

## Excluding Endpoints

- To exclude /health

File: `src/main/resources/application.properties`:

```
# Exclude individual endpoints with a comma-delimited list
#
management.endpoints.web.exposure.exclude=health
```

## Spring Boot Actuator Documentation

- https://docs.spring.io/spring-boot/reference/actuator/endpoints.html#page-title

## Development Process

1. Edit `pom.xml` and add `spring-boot-starter-security`
2. Verify security on actuator endpoints for: `/beans` etc
3. Disable endpoints for `/health` and `/info`
