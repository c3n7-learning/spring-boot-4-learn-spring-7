# Spring Boot Dev Tools - Overview

## The Problem

- When running Spring Boot applications
- If you make changes to your source code
- Then you have to manually restart your application :-(

## Solution: Spring Boot Dev Tools

- `spring-boot-devtools` to the rescue!
- Automatically restarts your application when code is updated
- Simply add the dependency to your POM file
- No need to write additional code :-)
- For IntelliJ, need to set additional configurations ... will discuss shortly

## Adding the dependency to your POM file

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

### IntelliJ Community Edition - DevTools

IntelliJ Community Edition does not support DevTools by default:

- Select: Preferences > Build, Execution, Deployment > Compiler
- Check box: Build project automatically

Additional setting

- Select: Preferences > Advanced Settings
- Check box: Allow auto-make to ...

### Development Process

1. Apply IntelliJ configurations
2. Edit `pom.xml` and add `spring-boot-devtools`
3. Add new REST endpoint to our app
4. Verify the app is automatically reloaded
