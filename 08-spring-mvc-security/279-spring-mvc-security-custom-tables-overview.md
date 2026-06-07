# Spring MVC Security - JDBC Authentication - Custom Tables - Overview

## Default Spring Security Database Schema

- So far, we have used spring's default database schema

![default schema](media/271-2-default-schema.webp)

## Custom Tables

- What if we have our own custom tables?
- Our own custom column names?

![custom schema](media/279-1-custom-schema.webp)

## For Security Schema Customization

- Tell Spring how to query your custom tables
- Provide query to find user by user name
- Provide query to find authorities / roles by user name

## Development Process

1. Create our custom tables with SQL
2. Update Spring Security Configuration
   - Provide query to find user by user name
   - Provide query to find authorities / roles by user name

## Step 1: Create our custom tables with SQL

- This is all custom Nothing matches with default Spring Security table schema

![custom schema](media/279-1-custom-schema.webp)

## Step 2: Update Spring Security Configuration

```java
@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        theUserDetailsManager
            .setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?"); // How to find users

        // Question mark “?”  Parameter value will be the user name from login
        theUserDetailsManager
            .setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?"); // How to find roles

        return theUserDetailsManager;
    }

    // ...

}
```
