# Querying Objects with JPA - Overview

JPA CRUD Apps

- Create objects
- Read objects
- **Update objects**
- Delete objects

## JPA Query Language (JPQL)

- Query language for retrieving objects
- Similar in concept to SQL
  - `where`, `like`, `order by`, `join`, `in`, etc…
- However, JPQL is based on entity name and entity fields

## Retrieving all Students

- `"FROM Student"` - Name of JPA Entity … the class name
- Note: this is NOT the name of the database table. All JPQL syntax is based on entity name and entity fields.

```java
TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
List<Student> students = theQuery.getResultList();
```

## Retrieving Students: `lastName = "Doe"`

- `lastName = "Doe"` - Field of JPA Entity

```java
TypedQuery<Student> theQuery = entityManager.createQuery(
                                  "FROM Student WHERE lastName=‘Doe’", Student.class);
List<Student> students = theQuery.getResultList();
```

## Retrieving Students using `OR` predicate:

- `lastName = "Doe"` - Field of JPA Entity
- `firstName = "Daffy"` - Field of JPA Entity

```java
TypedQuery<Student> theQuery = entityManager.createQuery(
                    "FROM Student WHERE lastName=‘Doe’ OR firstName=‘Daffy’", Student.class);
List<Student> students = theQuery.getResultList();
```

## Retrieving Students using `LIKE` predicate:

- `LIKE ‘%luv2code.com’`: Match of email addresses that ends with luv2code.com

```java
TypedQuery<Student> theQuery = entityManager.createQuery(
                      "FROM Student WHERE email LIKE ‘%luv2code.com’", Student.class);
List<Student> students = theQuery.getResultList();
```

## JPQL - Named Parameters

- `:theData`: JPQL Named Parameters are prefixed with a colon `:`
- Think of this as a placeholder that is filled in later

```java
public List<Student> findByLastName(String theLastName) {
  TypedQuery<Student> theQuery = entityManager.createQuery(
                                  "FROM Student WHERE lastName=:theData", Student.class);

  theQuery.setParameter("theData", theLastName);

  return theQuery.getResultList();
}
```

## JPQL - select clause

- The query examples so far did not specify a “select” clause
- The Hibernate implementation is lenient and allows Hibernate Query Language (HQL)
- For strict JPQL, the “select” clause is required

```java
TypedQuery<Student> theQuery = entityManager.createQuery("select s FROM Student s", Student.class);
```

The `s` in `select s`:

- is an “identification variable” / alias
- Provides a reference to the Student entity object
- `s` - Can be any name
- Useful for when you have complex queries

Other examples, for strict JPQL:

```java
TypedQuery<Student> theQuery = entityManager.createQuery(
                      "select s FROM Student s WHERE s.email LIKE ‘%luv2code.com’", Student.class);
```

or

```java
TypedQuery<Student> theQuery = entityManager.createQuery(
                      "select s FROM Student s WHERE s.lastName=:theData", Student.class);
```

## Development Process

1. Add new method to DAO interface
2. Add new method to DAO implementation
3. Update main app

## Step 1: Add new method to DAO interface

```java
import com.luv2code.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {
  // …
  List<Student> findAll();
}
```

## Step 2: Define DAO implementation

- `"FROM Student"`: Name of JPA Entity

```java
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

// …

public class StudentDAOImpl implements StudentDAO {
  private EntityManager entityManager;

  // …

  // No need to add @Transactional since we are doing a query
  @Override
  public List<Student> findAll() {
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
    return theQuery.getResultList();
  }
}
```

## Step 3: Update main app

```java
@SpringBootApplication
public class CruddemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(CruddemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
      queryForStudents(studentDAO);
    };
  }

  private void queryForStudents(StudentDAO studentDAO) {

      // get list of students
      List<Student> theStudents = studentDAO.findAll();

      // display list of students
      for (Student tempStudent : theStudents) {
        System.out.println(tempStudent);
      }
  }
}
```
