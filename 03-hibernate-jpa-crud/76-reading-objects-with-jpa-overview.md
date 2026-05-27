# Reading Objects with JPA - Overview

JPA CRUD Apps

- Create objects
- **Read objects**
- Update objects
- Delete objects

## Retrieving a Java Object with JPA

- Entity Class: `Student.class`
- Primary Key: `1`

```java
// retrieve/read from database using the primary key
// in this example, retrieve Student with primary key: 1
Student myStudent = entityManager.find(Student.class, 1);
```

- If not found, returns null

## Development Process

1. Add new method to DAO interface
2. Add new method to DAO implementation
3. Update main app

### Step 1: Add new method to DAO interface

```java
import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {
  // …
  Student findById(Integer id);
}
```

### Step 2: Define DAO implementation

![dao impl](media/76-1-dao-impl.png)

### Step 3: Update main app

```java
// ...

@Bean
public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
  return runner -> {
    readStudent(studentDAO);
  };
}

// ...

private void readStudent(StudentDAO studentDAO) {
  // create a student object
  System.out.println("Creating new student object...");
  Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

  // save the student object
  System.out.println("Saving the student...");
  studentDAO.save(tempStudent);

  // display id of the saved student
  System.out.println("Saved student. Generated id: " + tempStudent.getId());

  // retrieve student based on the id: primary key
  System.out.println("\nRetrieving student with id: " + tempStudent.getId());

  Student myStudent = studentDAO.findById(tempStudent.getId());

  System.out.println("Found the student: " + myStudent);
}
```
