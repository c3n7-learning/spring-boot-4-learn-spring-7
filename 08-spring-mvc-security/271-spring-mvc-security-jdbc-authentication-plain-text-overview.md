# Spring MVC Security - JDBC Authentication - Plain Text - Overview

## Database Access

- So far, our user accounts were hard coded in Java source code
- We want to add database access

| User ID | Password | Roles                    |
| ------- | -------- | ------------------------ |
| john    | test123  | EMPLOYEE                 |
| mary    | test123  | EMPLOYEE, MANAGER        |
| susan   | test123  | EMPLOYEE, MANAGER, ADMIN |

## Customize Database Access with Spring Security

- Can also customize the table schemas
- Useful if you have custom tables specific to your project / custom
- You will be responsible for developing the code to access the data
  - JDBC, JPA/Hibernate etc …

## Database Support in Spring Security

Out-of-the-box

- Follow Spring Security’s predefined table schemas

![db support](media/271-1-db-support.webp)

## Development Process

1. Develop SQL Script to set up database tables
2. Add database support to Maven POM file
3. Create JDBC properties file
4. Update Spring Security Configuration to use JDBC

## Default Spring Security Database Schema

![schema](media/271-2-default-schema.webp)

### Step 1: Develop SQL Script to setup database tables

#### Users

The schema:

```sql
CREATE TABLE `users` (
`username` varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
`enabled` tinyint NOT NULL,

PRIMARY KEY (`username`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;
```

The data:

- `{noop}` - The encoding algorithm id. The passwords are stored as plain text.
- `{test123}` - The password

```sql
INSERT INTO users VALUES
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);
```

#### Authorities (Roles)

The schema:

```sql
CREATE TABLE `authorities` (
`username` varchar(50) NOT NULL,
`authority` varchar(50) NOT NULL,

UNIQUE KEY `authorities_idx_1` (`username`,`authority`),

CONSTRAINT `authorities_ibfk_1`
FOREIGN KEY (`username`)
REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
```

The data:

- Internally Spring Security uses `ROLE_` prefix

```sql
INSERT INTO `authorities`
VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');
```

### Step 2: Add Database Support to Maven POM file

```xml
<!-- MySQL -->
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <scope>runtime</scope>
</dependency>
```

### Step 3: Create JDBC Properties File

In `application.properties`:

```conf
#
#
# JDBC connection properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
spring.datasource.username=springstudent
spring.datasource.password=springstudent
```

### Step 4: Update Spring Security to use JDBC

```java
@Configuration
public class DemoSecurityConfig {
  @Bean
  public UserDetailsManager userDetailsManager(DataSource dataSource) { // Inject data-source, auto-configured by spring
    // Tell Spring Security to use JDBC authentication with our data source
    return new JdbcUserDetailsManager(dataSource); // No longer hard-coding users :-)
  }

}
```
