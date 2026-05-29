# Spring Boot REST: Spring Data REST Configs and Sorting - Overview

## REST Endpoints

- By default, Spring Data REST will create endpoints based on entity type
- **Simple** pluralized form
  - First character of Entity type is lowercase
  - Then just adds an "s" to the entity

```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```

- In the above example: `<Employee..` entity leads to the `/employees` endpoint

### Pluralized Form

- Spring Data REST pluralized form is VERY simple
  - Just adds an "s" to the entity
- The English language is VERY complex!
  - Spring Data REST does NOT handle

| Singular | Plural  |
| -------- | ------- |
| Goose    | Geese   |
| Person   | People  |
| Syllabus | Syllabi |
| ...      | ...     |

### Problem

- Spring Data REST does not handle complex pluralized forms
- In this case, you need to specify plural name
- What if we want to expose a different resource name?
- Instead of `/employees` … use `/members`

### Solution

- Specify plural name / path with an annotation

```java
@RepositoryRestResource(path="members")
  public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```

- `http://localhost:8080/members`

## Pagination

- By default, Spring Data REST will return the first 20 elements
  - Page size = 20
- You can navigate to the different pages of data using query param
  - Pages are zero based

```
http://localhost:8080/employees?page=0
http://localhost:8080/employees?page=1
```

## Spring Data REST Configuration

- Following properties available: `application.properties`

| Name                                 | Description                                   |
| ------------------------------------ | --------------------------------------------- |
| `spring.data.rest.base-path`         | Base path used to expose repository resources |
| `spring.data.rest.default-page-size` | Default size of pages                         |
| `spring.data.rest.max-page-size`     | Maximum size of pages                         |
| ...                                  | ...                                           |

More properties available

- https://www.luv2code.com/spring-boot-props

### Sample Configuration

- `spring.data.rest.base-path=/magic-api`: http://localhost:8080/magic-api/employees
- `spring.data.rest.default-page-size=50`: Returns 50 elements per page

## Sorting

- You can sort by the property names of your entity
  - In our Employee exmaple, we have: `firstName`, `lastName` and `email`
- Sort by last name (ascending is default)
  - http://localhost:8080/employees?sort=lastName
- Sort by first name, descending
  - http://localhost:8080/employees?sort=firstName,desc
- Sort by last name, then first name, ascending
  - http://localhost:8080/employees?sort=lastName,firstName,desc
