# @OneToMany - Delete Course

## Delete course

- Delete the course by ID

## Add new DAO method to delete course

File: `AppDAOImpl.java`

```java
@Override
@Transactional
public void deleteCourseById(int theId) {
    // retrieve the course
    Course tempCourse = entityManager.find(Course.class, theId);

    // delete the course
    entityManager.remove(tempCourse);
}
```

## Main app

File: `CruddemoApplication.java`

```java
private void deleteCourseById(AppDAO appDAO) {
    int theId = 10;
    System.out.println("Deleting course id: " + theId);
    appDAO.deleteCourseById(theId);
    System.out.println("Done!");
}
```
