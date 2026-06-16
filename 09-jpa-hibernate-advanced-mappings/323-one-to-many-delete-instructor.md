# @OneToMany - Delete Instructor

## Delete instructor

- Find an instructor by ID
- Break association of all instructor’s courses
- Delete the instructor

## Add new DAO method to delete instructor

We only delete the instructor … not the associated course based on our cascade types

- If you don't remove instructor from course, you'll get a `constraint violation`

```
Caused by: java.sql.SQLIntegrityConstraintViolationException

Cannot delete or update a parent row: a foreign key constraint fails

(`hb-03-one-tomany`.`course`,
CONSTRAINT `FK_INSTRUCTOR` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`))
```

- An instructor ca not be deleted if it is referenced by a course
- You must remove the instructor from the course first

File: `AppDAOImpl.java`

```java
@Override
@Transactional
public void deleteInstructorById(int theId) {
    // retrieve the instructor
    Instructor tempInstructor = entityManager.find(Instructor.class, theId);
    List<Course> courses = tempInstructor.getCourses();

    // break associations of all courses for instructor
    for (Course tempCourse : courses) {
        // Remove the instructor from the courses
        tempCourse.setInstructor(null);
    }

    // delete the instructor
    entityManager.remove(tempInstructor);
}
```

## Main app

File: `CruddemoApplication.java`

```java
private void deleteInstructor(AppDAO appDAO) {
    int theId = 1;
    System.out.println("Deleting instructor id: " + theId);

    appDAO.deleteInstructorById(theId);
    System.out.println("Done!");
}
```
