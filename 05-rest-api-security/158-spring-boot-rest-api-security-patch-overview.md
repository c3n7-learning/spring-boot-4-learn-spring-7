# Spring Boot REST API Security - PATCH - Coding

## Our Example

| HTTP Method | Endpoint                        | CRUD Action        | Role        |
| ----------- | ------------------------------- | ------------------ | ----------- |
| GET         | /api/employees                  | Read all           | EMPLOYEE    |
| GET         | /api/employees/{employeeId}     | Read single        | EMPLOYEE    |
| POST        | /api/employees                  | Create             | MANAGER     |
| PUT         | /api/employees                  | Update             | MANAGER     |
| **PATCH**   | **/api/employees/{employeeId}** | **Partial Update** | **MANAGER** |
| DELETE      | /api/employees/{employeeId}     | Delete employee    | ADMIN       |

## Authorize Requests for MANAGER role

The `**` syntax: match on all sub-paths;

```java
requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER")
```
