# FAQ: Spring MVC Security - User Registration and Public Landing Page - Part 2

## FAQ: How to Add a Public Landing Page

Hands On: `08-spring-mvc-security/code/05-spring-mvc-security-landing-page`

## Question

I want my application to have a landing page that is accessible to everyone at first, the user can then signup or login to access specific features. Our current framework only points to the login page. How do i implement this scenario?

## Answer

Good question!

You can add a public view page and set up the security constraints to allow access to the view page.

In this example, we have a view page that anyone can access. Then they can click the link to access the secure pages.

![Landing Page Screenshot showing "luv2code Landing Page" with welcome text and "Access Secure Site (requires login)" link]

## Source Code

Here is a working code example of the project: **spring-security-landing-page.zip**

This project has the following mods:

1. Updated security configs to allow public access to landing page
2. Updated controller to send requests to landing page
3. New landing page

### Details below

---

### 1. Updated security configs to allow public access to landing page

See the config below. It will "permit all" access to the landing page "/". Also, for successful logout it will redirect to the landing page "/"

**File: DemoSecurityConfig.java**

```java
http.authorizeHttpRequests(configurer ->
    configurer
        .requestMatchers("/").permitAll()
        .requestMatchers("/employees/**").hasRole("EMPLOYEE")
        .requestMatchers("/leaders/**").hasRole("MANAGER")
        .requestMatchers("/systems/**").hasRole("ADMIN")
        .anyRequest().authenticated()
)
```

### 2. Update the logout success to URL to send user back to landing page when they logout.

```java
.logout(logout ->
    logout
        .permitAll()
        .logoutSuccessUrl("/")
)
```

### 3. Updated controller to send requests to landing page

In the controller file, added new "/" mapping to send to landing page. And changed the original home mapping to "/employees". see changes in bold.

**File: DemoController.java**

```java
@GetMapping("/")
public String showLanding() {
    return "landing";
}

@GetMapping("/employees")
public String showHome() {
    return "home";
}
```

### 4. New landing page

Created a new view page for landing information. Anyone can access this page

**File: src/main/resources/template/landing.html**

```html
<!DOCTYPE html>
<html
  xmlns:th="http://www.thymeleaf.org"
  xmlns:sec="http://www.thymeleaf.org/extras/spring-security"
>
  <head>
    <title>luv2code Landing Page</title>
  </head>

  <body>
    <h2>luv2code Landing Page</h2>
    <hr />

    <p>
      Welcome to the landing page! This page is open to the public ... no login
      required :-)
    </p>

    <hr />

    <p>
      <a th:href="@{/employees}">Access Secure Site</a>
    </p>
  </body>
</html>
```

To test the application, be sure to open a new private/incognito window.

Now when you run the application, anyone can access the public home page without logging in. If they follow through on the link, then they will be required to login.
