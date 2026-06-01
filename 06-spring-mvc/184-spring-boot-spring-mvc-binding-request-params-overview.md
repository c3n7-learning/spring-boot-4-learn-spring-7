# Spring Boot - Spring MVC Binding Request Params - Overview

## Code Example

- We want to create a new method to process form data
- Read the form data: student’s name
- Convert the name to upper case
- Add the uppercase version to the model

## Instead of using HttpServletRequest

```java
@RequestMapping("/processFormVersionTwo")
public String letsShoutDude(HttpServletRequest request, Model model) {
  // read the request parameter from the HTML form
  String theName = request.getParameter("studentName");
  …
}
```

## Bind variable using @RequestParam Annotation

Behind the scenes:

- Spring will read param from request: `studentName`
- Bind it to the variable: `theName`

```java
@RequestMapping("/processFormVersionTwo")
public String letsShoutDude(
    @RequestParam("studentName") String theName,
    Model model) {

  // now we can use the variable: theName
}
```
