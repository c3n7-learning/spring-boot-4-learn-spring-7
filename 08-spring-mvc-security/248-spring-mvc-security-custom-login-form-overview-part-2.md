# Spring MVC Security - Custom Login Form - Overview - Part 2

## Step 3: Create custom login form

Send data to login processing URL: `/authenticateTheUser`

- Login processing URL will be handled by Spring Security Filters
- You get it for free … no coding required

How to send the data?

- Must `POST` the data
- Spring Security defines default names for login form fields
  - User name field: `username`
  - Password field: `password`

File: `src/main/resources/templates/plain-login.html`

```html
<form action="#" th:action="@{/authenticateTheUser}" method="POST">
  <p>User name: <input type="text" name="username" /></p>

  <p>Password: <input type="password" name="password" /></p>

  <input type="submit" value="Login" />
</form>
```

## More Info on Context Path

What is this??? The `@` symbol

```html
<form action="#" th:action="@{/authenticateTheUser}" method="POST"></form>
```

- Context Path is same thing as Context Root
- The root path for your web application
  - Context Root: `my-ecommerce-app`
  - http://localhost:8080/my-ecommerce-app
- `@` Gives us access to context path dynamically

## Why use Context Path?

- Allows us to dynamically reference context path of application
- Helps to keep links relative to application context path
- If you change context path of app, then links will still work
- Much better than hard-coding context path …
