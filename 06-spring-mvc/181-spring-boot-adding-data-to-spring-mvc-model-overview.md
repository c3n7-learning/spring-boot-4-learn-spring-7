# Spring Boot - Adding Data to Spring MVC Model - Overview

## Spring Model

- The **Model** is a container for your application data
- In your Controller
  - You can put anything in the **model**
  - strings, objects, info from database, etc…
- Your View page can access data from the **model**

## Code Example

- We want to create a new method to process form data
- Read the form data: student’s name
- Convert the name to upper case
- Add the uppercase version to the model

## Passing Model to your Controller

```java
@RequestMapping("/processFormVersionTwo")
public String letsShoutDude(HttpServletRequest request, Model model) {

    // read the request parameter from the HTML form
    String theName = request.getParameter("studentName");

    // convert the data to all caps
    theName = theName.toUpperCase();

    // create the message
    String result = "Yo! " + theName;

    // add message to the model
    model.addAttribute("message", result);

    return "helloworld";
}
```

## View Template - Thymeleaf

```java
<html><body>

Hello World of Spring!
...
The message: <span th:text="${message}"" />

</body></html>
```

## Adding more data to your Model

```java
// get the data
//
String result = ...
List<Student> theStudentList = ...
ShoppingCart theShoppingCart = ...

// add data to the model
//
model.addAttribute("message", result);

model.addAttribute("students", theStudentList);

model.addAttribute("shoppingCart", theShoppingCart);
```
