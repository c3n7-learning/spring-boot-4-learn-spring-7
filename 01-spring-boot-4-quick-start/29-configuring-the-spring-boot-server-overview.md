# Configuring the Spring Boot Server

- Spring Boot can be configured in the application.properties file
- Server port, context path, actuator, security etc …
- Spring Boot has 1,000+ properties … wowzers!

List of Common Properties

- https://www.luv2code.com/spring-boot-props

Don’t let the 1,000+ properties overwhelm you. The properties are roughly grouped into the following categories:

- Core
- Web
- Security
- Data
- Actuator
- Integration
- DevTools
- Testing

## Core Properties

Logging Levels:

- TRACE
- DEBUG
- INFO
- WARN
- ERROR
- FATAL
- OFF

```
# Log levels severity mapping
logging.level.org.springframework=DEBUG
logging.level.org.hibernate=TRACE
logging.level.com.luv2code=INFO

# Log file name
logging.file.name=my-crazy-stuff.log
logging.file.path=c:/myapps/demo
```

- http://www.luv2code.com/spring-boot-logging
- https://docs.spring.io/spring-boot/reference/features/logging.html

## Web Properties

```
# HTTP server port
server.port=7070

# Context path of the application
server.servlet.context-path=/my-silly-app

# Default HTTP session time out
server.servlet.session.timeout=15m
```

## Actuator Properties

```
# Endpoints to include by name or wildcard
management.endpoints.web.exposure.include=*

# Endpoints to exclude by name or wildcard
management.endpoints.web.exposure.exclude=beans,mapping

# Base path for actuator endpoints
management.endpoints.web.base-path=/actuator
```

## Security Properties

```
# Default user name
spring.security.user.name=admin

# Password for default user
spring.security.user.password=topsecret
```

## Data Properties

```
# JDBC URL of the database
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce

# Login username of the database
spring.datasource.username=scott

# Login password of the database
spring.datasource.password=tiger
```

## Development Process

1. Configure the server port
2. Configure the application context path
