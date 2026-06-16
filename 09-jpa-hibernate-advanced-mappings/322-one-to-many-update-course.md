# @OneToMany - Update Course

## Update Course

- Find a course by ID
- Change the course’s data by calling setter method(s)
- Update the course using the DAO

## Add new DAO method to update course

- `merge(…)` will update an existing entity
  File: `AppDAOImpl.java`

```java
@Override
@Transactional
public void update(Course tempCourse) {
    entityManager.merge(tempCourse);
}
```

## Main app

File: `CruddemoApplication.java`

```java
private void updateCourse(AppDAO appDAO) {
    int theId = 10;
    System.out.println("Finding course id: " + theId);

    Course tempCourse = appDAO.findCourseById(theId);

    System.out.println("Updating course id: " + theId);
    tempCourse.setTitle("Enjoy the Simple Things");

    appDAO.update(tempCourse);

    System.out.println("Done");
}
```
