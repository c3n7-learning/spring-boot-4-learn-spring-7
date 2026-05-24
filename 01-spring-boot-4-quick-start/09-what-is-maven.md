# What is Maven

## Spring Boot and Maven

- When you generate projects using Spring Initializr: start.spring.io
- It can generate a Maven project for you
- In this section, we will learn the basics of Maven
- Viewing dependencies in the Maven pom.xml file
- Spring Boot Starters for Maven

## What is Maven?

- Maven is a Project Management tool
- Most popular use of Maven is for build management and dependencies

## What Problems Does Maven Solve?

- When building your Java project, you may need additional JAR files
- For example: Spring, Hibernate, Commons Logging, JSON etc…
- One approach is to download the JAR files from each project web site
- Manually add the JAR files to your build path / classpath

## Maven Solution

- Tell Maven the projects you are working with (dependencies)
- Spring, Hibernate etc ….
- Maven will go out and download the JAR files for those projects for you
- And Maven will make those JAR files available during compile/run
- Think of Maven as your friendly helper / personal shopper :-)

## Handling JAR Dependencies

- When Maven retrieves a project dependency
- It will also download supporting dependencies
- For example: Spring depends on commons-logging …
- Maven will handle this for us automagically

## Building and Running

- When you build and run your app …
- Maven will handle class / build path for you
- Based on config file, Maven will add JAR files accordingly
