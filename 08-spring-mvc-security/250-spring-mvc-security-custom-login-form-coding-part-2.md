# Spring MVC Security - Custom Login Form - Coding - Part 2

Hands On: `08-spring-mvc-security/code/01-spring-boot-mvc-security-default`

```html
<!DOCTYPE html>
<!-- XML Namespace is a unique identifier for XML elements, attributes, etc -->
<!-- In this case, we use the XML Namespace for Thymeleaf (the "th": attributes) -->
<!-- The XML Namespace does not connect to the internet ... -->
<!-- Just a unique identifier that is configured in the Thymeleaf JAR file -->
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>Custom Login Page</title>
  </head>
  <body>
    <h3>My Custom Login Page</h3>

    <form action="#" th:action="@{/authenticateTheUser}" method="POST">
      <p>User name: <input type="text" name="username" /></p>

      <p>Password: <input type="password" name="password" /></p>

      <input type="submit" value="Login" />
    </form>
  </body>
</html>
```
