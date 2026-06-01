# Spring Boot - Spring MVC Validation - Validate a Number Range - Overview

## Validate a Number Range

- Add a new input field on our form for: Free Passes
- User can only enter a range: 0 to 10

## Development Process

1. Add validation rule to Customer class
2. Display error messages on HTML form
3. Perform validation in the Controller class
4. Update confirmation page

### Step 1: Add validation rule to Customer class

```java
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public class Customer {

@Min(value=0, message="must be greater than or equal to zero")
@Max(value=10, message="must be less than or equal to 10")
private int freePasses;

// getter/setter methods

}
```
