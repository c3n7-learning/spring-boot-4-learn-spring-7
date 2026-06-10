# @OneToOne Mapping - Delete Instructor by ID

Hands On: `09-jpa-hibernate-advanced-mappings/code/01-jpa-one-to-one-uni`

## Define DAO implementation

```java
@Repository
public class AppDAOImpl implements AppDAO {
    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        // delete the instructor
        entityManager.remove(tempInstructor);
    }
}
```

This will ALSO delete the instructor details object

- Because of CascadeType.ALL

- We’ll add supporting code in the video: interface, main app
