# Spring Boot - Spring MVC Validation - Applying Regular Expressions - Overview

Advanced

- A sequence of characters that define a search pattern
  - This pattern is used to find or match strings
- Regular Expressions is like its own language (advanced topic)
  - I will assume you already know about regular expressions
- If not, then plenty of free tutorials available
  - https://docs.oracle.com/javase/tutorial/essential/regex/

## Validate a Postal Code

- Add a new input field on our form for: Postal Code
- User can only enter 5 chars / digits
- Apply **_Regular Expression_**

## Development Process

1. Add validation rule to Customer class
2. Display error messages on HTML form
3. Update confirmation page

## Step 1: Add validation rule to Customer class

```java
import jakarta.validation.constraints.Pattern;

public class Customer {

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
    private String postalCode;

    // getter/setter methods

}
```
