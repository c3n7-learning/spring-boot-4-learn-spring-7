# Spring Boot - Spring MVC Validation - Custom Validation - Overview - Part 2

## Step 1a: Create @CourseCode annotation

Usage Example

```java
@CourseCode(value="LUV", message="must start with LUV")
private String courseCode;
```

The Rule:

- `@interface` - is how you define a custom annotation in java
- `@Constraint(validatedBy = CourseCodeConstraintValidator.class)` - Helper class that contains business rules / validation logic
- `@Target( { ElementType.METHOD, ElementType.FIELD } )` - Q: Where can you apply our anotation? (A: to a method or field)
- `@Retention(RetentionPolicy.RUNTIME)` - Retain this annotation in the Java class file (the bytecode). Process it at runtime

```java
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
  // the annotation accepts a parameter called 'value'
  // define default course code
  public String value() default "LUV";

// the annotation accepts a parameter called 'message'
  // define default error message
  public String message() default "must start with LUV";
  // ...
}
```

## Step 1b: Create CourseCodeConstraintValidator

- `ConstraintValidator<CourseCode, String>`:
  - `CourseCode` - Our annotation
  - `String` - Type of data to validate against

```java
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
    implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode,
                           ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        }
        else {
            result = true;
        }

        return result;
    }
}
```
