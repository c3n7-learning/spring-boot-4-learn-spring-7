# Spring Boot Overview

## Spring in a Nutshell

- Very popular framework for building Java applications
- Provides a large number of helper classes and annotations

## The Problem

- Building a traditional Spring application is really HARD!!!

Q: Which JAR dependencies do I need?
Q: How do I set up configuration (xml or Java)?
Q: How do I install the server? (Tomcat, JBoss etc…)

- And that's JUST the basics for getting started

## Spring Boot Solution

- Make it easier to get started with Spring development
- Minimize the amount of manual configuration
- Perform auto-configuration based on props files and JAR classpath
- Help to resolve dependency conflicts (Maven or Gradle)
- Provide an embedded HTTP server so you can get started quickly
- Tomcat, Jetty, Undertow, …

## Spring Boot and Spring

- Spring Boot uses Spring behind the scenes
- Spring Boot simply makes it easier to use Spring

## Spring Initializr

- Quickly create a starter Spring Boot project
- Select your dependencies
- Creates a Maven/Gradle project
- Import the project into your IDE
- Eclipse, IntelliJ, NetBeans etc …

## Spring Boot Embedded Server

- Provide an embedded HTTP server so you can get started quickly
- Tomcat, Jetty, Undertow, …
- No need to install a server separately

## Running Spring Boot Apps

- Spring Boot apps can be run standalone (includes embedded server)
- Run the Spring Boot app from the IDE or command-line

## Deploying Spring Boot Apps

- Spring Boot apps can also be deployed in the traditional way
- Deploy Web Application Archive (WAR) file to an external server:
- Tomcat, JBoss, WebSphere etc …

## Spring Boot FAQ

Q: Does Spring Boot replace Spring MVC, Spring REST etc …?

- No. Instead, Spring Boot actually uses those technologies

Q: Does Spring Boot run code faster than regular Spring code?

- No.
- Remember, Spring Boot is about making it easier to get started
- Minimizing configuration etc …

Q: Do I need a special IDE for Spring Boot?

- No.
- You can use any IDE for Spring Boot apps … even use plain text editor
- The Spring team provides free Spring Tool Suite (STS) [IDE plugins]
- Some IDEs provide fancy Spring tooling support
- Not a requirement. Feel free to use the IDE that works best for you
