# Spring Boot - Spring MVC Validation - Custom Validation - Overview - Part 1

## Custom Validation

- Perform custom validation based on your business rules
  - Our example: Course Code must start with “LUV”
- Spring MVC calls our custom validation
- Custom validation returns boolean value for pass/fail (true/false)

## Create a custom Java Annotation … from scratch

Advanced:

- So far, we’ve used predefined validation rules: `@Min`, `@Max`, …
- For custom validation … we will create a Custom Java Annotation
  - `@CourseCode`

```java
@CourseCode(value="LUV", message="must start with LUV")
private String courseCode;
```

## Development Process

1. Create custom validation rule
2. Add validation rule to Customer class
3. Display error messages on HTML form
4. Update confirmation page

## Development Process - Drill Down

1. Create custom validation rule  
   a. Create `@CourseCode` annotation  
   b. Create `CourseCodeConstraintValidator`
