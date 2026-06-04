# Spring MVC Security - Logout - Overview

## Development Process

1. Add logout support to Spring Security Configuration
2. Add logout button to home page
3. Update login form to display “logged out” message

## Step 1: Add Logout support to Spring Security Configuration

File: `DemoSecurityConfig.java`

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(configurer ->
            configurer
                .anyRequest().authenticated()
    )
    .formLogin(form ->
            form
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
    )
    .logout(logout -> logout.permitAll() // Add logout support for default URL /logout
    );

    return http.build();
}
```

## Step 2: Add logout button

Send data to default logout URL: /logout

- Logout URL will be handled by Spring Security Filters
- You get it for free … no coding required

By default, must use `POST` method

```html
<form action="#" th:action="@{/logout}" method="POST">
  <input type="submit" value="Logout" />
</form>
```

## Logout process

- When a logout is processed, by default Spring Security will …
- Invalidate user’s HTTP session and remove session cookies, etc
- Send user back to your login page
- Append a logout parameter: `?logout`
  - `http://localhost:8080/showMyLoginPage?logout`

## Step 3: Update login form to display “logged out” message

1. Update login form
   1. Check the _logout_ parameter
   2. If _logout_ parameter exists, show “logged out” message

## Modify Login form - check for "logout"

```html
<form … th:action="…" method="…">
  <div th:if="${param.logout}">
    <!-- If logout param then show message -->
    <i>You have been logged out.</i>
  </div>
  User name: <input type="text" name="username" /> Password:
  <input type="password" name="password" />
</form>
```
