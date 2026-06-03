# Spring MVC Security Overview

## You will learn how to …

- Secure Spring MVC Web Apps
- Develop login pages (default and custom)
- Define users and roles with simple authentication
- Protect URLs based on role
- Hide/show content based on role
- Store users, passwords and roles in DB (plain-text -> encrypted)

## Practical Results

- Cover the most common Spring Security tasks that you will need on daily projects
- Not an A to Z reference … for that you can see Spring Security Reference Manual
  - http://www.luv2code.com/spring-security-reference-manual

## Spring Security Model

- Spring Security defines a framework for security
- Implemented using Servlet filters in the background
- Two methods of securing an app: declarative and programmatic

## Spring Security with Servlet Filters

- Servlet Filters are used to pre-process / post-process web requests
- Servlet Filters can route web requests based on security logic
- Spring provides a bulk of security functionality with servlet filters

## Spring Security Overview

![overview](media/240-1-overview.webp)

Flowchart:

![flowchart](media/240-2-flowchart.webp)

## Security Concepts

- Authentication
  - Check user id and password with credentials stored in app / db
- Authorization
  - Check to see if user has an authorized role

## Declarative Security

- Define application’s security constraints in configuration
  - All Java config: `@Configuration`
- Provides separation of concerns between application code and security

## Programmatic Security

- Spring Security provides an API for custom application coding
- Provides greater customization for specific app requirements

## Enabling Spring Security

1. Edit pom.xml and add spring-boot-starter-security

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

2. This will automagically secure all endpoints for application

## Secured Endpoints

- Now when you access your application
- Spring Security will prompt for login

![default auth](media/240-3-default-auth.webp)

## Different Login Methods

- HTTP Basic Authentication
- Default login form
  - Spring Security provides a default login form
- Custom login form
  - your own look-and-feel, HTML + CSS

## HTTP Basic Authentication

![basic auth](media/240-4-basic-auth.webp)

## Spring Security - Default Login Form

![default login](media/240-5-default-login.webp)

## Your Own Custom Login Form

![custom login](media/240-6-custom-login.webp)
