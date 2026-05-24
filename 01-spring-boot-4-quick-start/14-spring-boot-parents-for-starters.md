# Spring Boot Parents for Starters

Spring Boot provides a "Starter Parent"

- This is a special starter that provides Maven defaults

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>4.0.0</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

Maven defaults defined in the Starter Parent

- Default compiler level
- UTF-8 source encoding
- Others …

To override a default, set as a property:

```xml
<properties>
    <java.version>25</java.version>
</properties>
```

For the `spring-boot-starter-*` dependencies, no need to list version:

- No need to list individual versions. Great for maintenance!

```xml
<!-- Specify version of spring boot -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>4.0.0</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
        <!-- Inherit version from starter parent -->
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webmvc</artifactId>
        <!-- Inherit version from starter parent -->
    </dependency>
</dependencies>
```

It also provides the default configuration of Spring Boot plugin:

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

- Meaning we can simply run:

```shell
$ mvn spring-boot:run
```

## Benefits of the Spring Boot Starter Parent

- Default Maven configuration: Java version, UTF-encoding etc
- Dependency management
  - Use version on parent only
  - `spring-boot-starter-*` dependencies inherit version from parent
- Default configuration of Spring Boot plugin
