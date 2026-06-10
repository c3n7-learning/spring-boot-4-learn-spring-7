# @OneToOne Mapping - Find Instructor by ID

Hands On: `09-jpa-hibernate-advanced-mappings/code/01-jpa-one-to-one-uni`

## Define DAO implementation

```java
@Repository
public class AppDAOImpl implements AppDAO {
  @Override
  public Instructor findInstructorById(int theId) {
    return entityManager.find(Instructor.class, theId);
  }
}
```

This will ALSO retrieve the instructor details object

- Because of default behavior of `@OneToOne` fetch type is eager … more on fetch types later

- We’ll add supporting code in the video: interface, main app
