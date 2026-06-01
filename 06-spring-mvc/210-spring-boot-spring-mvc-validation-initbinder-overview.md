# Spring Boot - Spring MVC Validation - @InitBinder - Overview

## White Space

Our previous example had a problem with white space

- Last name field with all whitespace passed … YIKES!
  - Should have failed!
- We need to trim whitespace from input fields

## @InitBinder

Is an advanced annotation:

- `@InitBinder` annotation works as a pre-processor
- It will pre-process each web request to our controller
- Method annotated with `@InitBinder` is executed

For us:

- We will use this to trim Strings
  - Remove leading and trailing white space
- If String only has white spaces … trim it to null
- Will resolve our validation problem … whew :-)

## Register Custom Editor in Controller

`StringTrimmerEditor` is defined in the Spring API

- Removes whitespace - leading and trailing
- the `true` in the constructor means _trim to null_

In `CustomerController.java`:

```java
@InitBinder
public void initBinder(WebDataBinder dataBinder) {

  StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

  dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
}
```

This will:

- Pre-process every String form data
- Remove leading and trailing white space
- If String only has white space, trim it to `null`
