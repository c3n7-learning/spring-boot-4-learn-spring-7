# 403 ERROR with PUT Request - Spring Data REST

- This is a non-issue if using code provided for this lecture `@RestController`
- When using Spring Data REST for PUT requests the ID is on the URL:
  - `/api/employees/{employeeId}`
- As a result, need to modify the security configuration

## Step 01:

In: `DemoSecurityConfig.java`:
Replace

```java
.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
```

With

```java
.requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
```

Note use of `/**`:

- Because the ID is passed on the URL
- For PUT requests using Spring Data REST
