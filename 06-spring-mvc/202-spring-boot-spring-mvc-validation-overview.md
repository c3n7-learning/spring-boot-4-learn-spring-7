# Spring Boot - Spring MVC Validation - Overview

## The Need for Validation

Check the user input form for

- required fields
- valid numbers in a range
- valid format (postal code)
- custom business rule

## Java’s Standard Bean Validation API

https://beanvalidation.org

- Java has a standard Bean Validation API
- Defines a metadata model and API for entity validation
- Spring Boot and Thymeleaf also support the Bean Validation API

## Bean Validation Features

| Validation Feature                |
| --------------------------------- |
| required                          |
| validate length                   |
| validate numbers                  |
| validate with regular expressions |
| custom validation                 |

## Validation Annotations

| Annotation      | Description                                  |
| --------------- | -------------------------------------------- |
| @NotNull        | Checks that the annotated value is not null  |
| @Min            | Must be a number >= value                    |
| @Max            | Must be a number <= value                    |
| @Size           | Size must match the given size               |
| @Pattern        | Must match a regular expression pattern      |
| @Future / @Past | Date must be in future or past of given date |
| others ...      |                                              |

## Our Road Map

1. set up our development environment
2. required field
3. validate number range: min, max
4. validate using regular expression (regexp)
5. custom validation
