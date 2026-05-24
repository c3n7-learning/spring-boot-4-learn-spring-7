# Run Spring Boot apps from the Command Line - Microsoft Windows

Hands On: `01-spring-boot-4-quick-start/code/05-command-line-demo`:

- https://www.youtube.com/watch?v=UxmzxT4YglQ

```shell
> echo %JAVA_HOME%

D:\Users\karani\openjdk-25.0.3_windows-x64_bin\jdk-25.0.3

> java --version

openjdk 25.0.3 2026-04-21
OpenJDK Runtime Environment Homebrew (build 25.0.3)
OpenJDK 64-Bit Server VM Homebrew (build 25.0.3, mixed mode, sharing)
```

In the project directory

Package the app:

```shell
> mvnw package

[INFO] Replacing main artifact /Users/timothy.karani/Documents/c3n7/java/spring-boot-4-learn-spring-7/01-spring-boot-4-quick-start/code/05-command-line-demo/target/mycoolapp-0.0.1-SNAPSHOT.jar with repackaged archive, adding nested dependencies in BOOT-INF/.
[INFO] The original artifact has been renamed to /Users/timothy.karani/Documents/c3n7/java/spring-boot-4-learn-spring-7/01-spring-boot-4-quick-start/code/05-command-line-demo/target/mycoolapp-0.0.1-SNAPSHOT.jar.original
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  12.009 s
[INFO] Finished at: 2026-05-24T19:03:30+03:00
[INFO] ------------------------------------------------------------------------
```

Run the file

```shell
> java -jar target/mycoolapp-0.0.1-SNAPSHOT.jar
```

Run the app using Spring Boot Maven plugin:

```shell
> mvnw spring-boot:run
```
