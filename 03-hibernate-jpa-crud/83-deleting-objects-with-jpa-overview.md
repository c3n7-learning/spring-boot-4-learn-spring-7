# Deleting Objects with JPA - Overview

JPA CRUD Apps

- Create objects
- Read objects
- Update objects
- **Delete objects**

## Delete a Student

```java
// retrieve the student
int id = 1;
Student theStudent = entityManager.find(Student.class, id);

// delete the student
entityManager.remove(theStudent);
```

## Delete based on a condition

- `numRowsDeleted`: Return the number of rows deleted
- `Student`: Name of JPA Entity; the class name
- `lastName`: Field of JPA Entity
- `executeUpdate`: Execute this statement
  - Method name “Update” is a generic term
  - We are “modifying” the database

```java
int numRowsDeleted = entityManager.createQuery(
                      "DELETE FROM Student WHERE lastName=‘Smith’")
                      .executeUpdate();
```

## Delete All Students

```java
int numRowsDeleted = entityManager
                        .createQuery("DELETE FROM Student")
                        .executeUpdate();
```

## Development Process

1. Add new method to DAO interface
2. Add new method to DAO implementation
3. Update main app

## Step 1: Add new method to DAO interface

```java
import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {
  // …
  void delete(Integer id);
}
```

## Step 2: Define DAO implementation

- Add `@Transactional` since we are performing a delete

```java
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
// ...

public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;
    // ...

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }
}
```

## Step 3: Update main app

```java
@Bean
public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {

        deleteStudent(studentDAO);
    };
}

private void deleteStudent(StudentDAO studentDAO) {
    // delete the student
    int studentId = 3;

    System.out.println("Deleting student id: " + studentId);

    studentDAO.delete(studentId);
}
```
