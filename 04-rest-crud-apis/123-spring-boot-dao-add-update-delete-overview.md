# Spring Boot DAO: Add, Update, Delete - Overview

## Service Layer - Best Practice

- Best practice is to apply transactional boundaries at the service layer
- It is the service layer’s responsibility to manage transaction boundaries

For implementation code

- Apply `@Transactional` on service methods
- Remove `@Transactional` on DAO methods if they already exist

## Development Process

1. Set up Database Dev Environment
2. Create Spring Boot project using Spring Initializr
3. Get list of employees

DAO Methods:

4. Get single employee by ID
5. Add a new employee
6. Update an existing employee
7. Delete an existing employee

## DAO: Get a single employee

```java
@Override
public Employee findById(int theId) {

  // get employee
  Employee theEmployee = entityManager.find(Employee.class, theId);

  // return employee
  return theEmployee;
}
```

## DAO: Add or Update employee

- Note: We don’t use `@Transactional` at DAO layer. It will be handled at Service layer
- `merge` does a save or update
  - `if id==0 then save/insert else update`

```java
@Override
public Employee save(Employee theEmployee) {

  // save or update the employee
  Employee dbEmployee = entityManager.merge(theEmployee);

  // return the updated dbEmployee
  return dbEmployee;
}
```

## DAO: Delete an existing employee

- Note: We don’t use `@Transactional` at DAO layer. It will be handled at Service layer

```java
@Override
public void deleteById(int theId) {

  // find the employee by id
  Employee theEmployee = entityManager.find(Employee.class, theId);

  // delete the employee
  entityManager.remove(theEmployee);
}
```
