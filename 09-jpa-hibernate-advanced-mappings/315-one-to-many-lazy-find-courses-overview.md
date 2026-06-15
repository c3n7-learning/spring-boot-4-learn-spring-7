# @OneToMany: Lazy Find Courses - Overview

## Previous Solution: Eager

- **Eager** will retrieve everything … all of the courses for an instructor
- But we may not want this ALL of the time
- We’d like the option to load courses as needed …

## Fetch Type

Change the fetch type back to LAZY

- FetchType for @OneToMany defaults to lazy … But I will explicitly list it for readability

```java
@Entity
@Table(name="instructor")
public class Instructor {
    // …
    @OneToMany(fetch=FetchType.LAZY, mappedBy=“instructor”)
    private List<Course> courses;
    // …
}
```

## Add new method to find courses for instructor

File: `AppDAOImpl.java`:

```java
@Override
public List<Course> findCoursesByInstructorId(int theId) {

    // create query
    TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);

    query.setParameter("data", theId);

    // execute query
    List<Course> courses = query.getResultList();

    return courses;
}
```

File: `CruddemoApplication.java`

```java
private void findCoursesForInstructor(AppDAO appDAO) {
    int theId = 1;

    // find the instructor
    // Since fetch type for courses is lazy,
    // This will retrieve the instructor WITHOUT courses
    Instructor tempInstructor = appDAO.findInstructorById(theId);
    System.out.println("tempInstructor: " + tempInstructor);

    // find courses for instructor
    List<Course> courses = appDAO.findCoursesByInstructorId(theId);

    // associate the objects
    tempInstructor.setCourses(courses);

    System.out.println("the associated courses: " + tempInstructor.getCourses());
}
```
