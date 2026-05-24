# Run Spring Boot apps from the Command Line - Overview

## Running from the Command-Line

- During development we spend most of our time in the IDE
- However, we may want to run our Spring Boot app outside of the IDE
- One approach is running from the command-line

When running from the command-line

- No need to have IDE open/running
- Since we using Spring Boot, the server is embedded in our JAR file
- No need to have separate server installed/running
- Spring Boot apps are self-contained

Spring Boot apps are self-contained

- The JAR file includes your **application code** AND includes the **server** (tomcat)

Two options for running the app

- Option 1: Use `java -jar`
  - `java -jar mycoolapp.jar`
- Option 2: Use Spring Boot Maven plugin
  - `mvnw spring-boot:run`

## Option 1: Use java -jar

```shell
$ java -jar mycoolapp.jar
```

## Option 2: Use Spring Boot Maven plugin

`mvnw` allows you to run a Maven project

- No need to have Maven installed or present on your path
- If correct version of Maven is NOT found on your computer
- Automatically downloads correct version and runs Maven

Two files are provided

- `mvnw.cmd` for MS Windows
  - `> mvnw clean compile test`
- `mvnw.sh` for Linux/Mac
  - `$ ./mvnw clean compile test`

### Maven Wrapper Files

If you already have Maven installed previously

- Then you can ignore/delete the mvnw files
- Just use Maven as you normally would

```
$ mvn clean compile test
```

In `pom.xml`, we already have the plugin installed

- We can use it to package the executable jar or war archive
- We can also use it to easily run the app

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
  </plugins>
</build>
```

## Development Process

1. Exit the IDE
2. Package the app using `mvnw` package
3. Run app using `java -jar`
4. Run app using Spring Boot Maven plugin, `mvnw spring-boot:run`
