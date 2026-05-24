# Exploring Spring Boot Project Files - Part 1

Spring Boot Project Structure

## Spring Initializr

- Spring Initializr created a Maven project for us
- Let's explore the project structure

## Maven Standard Directory Structure

| Directory          | Description                                |
| ------------------ | ------------------------------------------ |
| src/main/java      | Your Java source code                      |
| src/main/resources | Properties / config files used by your app |
| src/test/java      | Unit testing source code                   |

## Maven Wrapper files

`mvnw` allows you to run a Maven project

- No need to have Maven installed or present on your path
- If correct version of Maven is NOT found on your computer
- **Automatically downloads** correct version and runs Maven

Two files are provided

- mvnw.cmd for MS Windows
- mvnw.sh for Linux/Mac

```shell
# windows
> mvnw clean compile test

# mac/linux
$ ./mvnw clean compile test
```

## Maven Wrapper files

- If you already have Maven installed previously
- Then you can ignore/delete the mvnw files
- Just use Maven as you normally would

```shell
$ mvn clean compile test
```

## Maven POM file

- `pom.xml` includes info that you entered at Spring Initializr website

```xml
<groupId>com.luv2code.springboot.demo</groupId>
<artifactId>mycoolapp</artifactId>
<version>0.0.1-SNAPSHOT</version>

<!-- ===========================================================================-->
<!-- Spring Boot Starters: -->
<!-- ===========================================================================-->
<!-- A collection of Maven Dependencies (Compatible versions) -->
<!-- Save's the developer from having to list all of the individual dependencies -->
<!-- Also, makes sure you have compatible versions -->
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc-test</artifactId>
    <scope>test</scope>
  </dependency>
<!-- … -->
</dependencies>
```

### Spring Boot Maven plugin

- To package executable jar or war archive
- Can also easily run the app

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

Then run it as:

```shell
$ ./mvnw package
$ ./mvnw spring-boot:run
```

Or:

```shell
mvn package
mvn spring-boot:run
```

## Java Source Code

`com/karani/springboot/demo/mycoolapp/MycoolappApplication.java`:

- Main Spring Boot application class
- Created by Spring Initializr

`com/karani/springboot/demo/mycoolapp/rest/FunRestController.java`:

- `RestController` that we created in an earlier video
