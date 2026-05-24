# Spring Boot Actuator

## Problem

- How can I monitor and manage my application?
- How can I check the application health?
- How can I access application metrics?

## Solution: Spring Boot Actuator

- Exposes endpoints to monitor and manage your application
- You easily get DevOps functionality out-of-the-box
- Simply add the dependency to your POM file
- REST endpoints are _automatically_ added to your application

## Adding the dependency to your POM file

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

## The Endpoints

- Automatically exposes endpoints for metrics out-of-the-box
- Endpoints are prefixed with: `/actuator`
- There are 20+ actuator endpoints
- https://docs.spring.io/spring-boot/reference/actuator/endpoints.html#page-title

| Name         | Description                                                    |
| :----------- | :------------------------------------------------------------- |
| `/healthz`   | Health information about your application                      |
| `...`        | ...                                                            |
| /auditevents | Audit events for your application                              |
| /beans       | List of all beans registered in the Spring application context |
| /mappings    | List of all @RequestMapping paths                              |

### Health Endpoint

- `/health` checks the status of your application
- Normally used by monitoring apps to see if your app is up or down
- Health status is customizable based on your own business logic

You'll then see in `http://localhost:8080/actuator/health`:

```json
{ "status": "UP" }
```

### Exposing Endpoints

- By default, only `/health` is exposed
- The `/info` endpoint can provide information about your application
- To expose `/info`

File: `src/main/resources/application.properties`:

```
management.endpoints.web.exposure.include=health,info
management.info.env.enabled=true
```

### Info Endpoint

- /info gives information about your application
- Default is empty

```json
{}
```

#### Updating info properties

Update `application.properties` with your app info:

```
info.app.name=My Super Cool App
info.app.description=A crazy and fun app, yoohoo!
info.app.version=1.0.0
```

You'll then see in `http://localhost:8080/actuator/info`:

```json
{
  "app": {
    "name": "My Super Cool App",
    "description": "A crazy and fun app, yoohoo!",
    "version": "1.0.0"
  }
}
```

## Exposing Endpoints

- By default, only /health is exposed
- To expose all actuator endpoints over HTTP

File: src/main/resources/application.properties

```
# Use wildcard "*" to expose all endpoints
# Can also expose individual endpoints with a comma-delimited list
#
management.endpoints.web.exposure.include=*
```

### Get A List of Beans

- Access `http://localhost:8080/actuator/beans`

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

## Development Process

Step-By-Step

1. Edit `pom.xml` and add `spring-boot-starter-acuator`
2. View `actuator` endpoints for: `/health`
3. Edit `application.properties` to customize `/info`
