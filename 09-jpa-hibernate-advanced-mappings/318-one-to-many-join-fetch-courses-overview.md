# @OneToMany - JOIN FETCH Courses - Overview

Lazy: Find Instructor with Courses

## Previous Solution: Find Courses for Instructor

Previous solution was OK … but …

- Required an extra query
- I wish we could have a new method that would
- Get instructor AND courses … in a single query
  - Also keep the LAZY option available … don’t change fetch type

## Add new method to find instructor with courses

Even with Instructor `@OneToMany(fetchType=LAZY)`,

- This code will still retrieve Instructor AND Courses
- The JOIN FETCH is similar to EAGER loading

File: `AppDAOImpl.java`:

```java
@Override
public Instructor findInstructorByIdJoinFetch(int theId) {
    // create query
    TypedQuery<Instructor> query = entityManager.createQuery(
                                        "select i from Instructor i "
                                                + "JOIN FETCH i.courses "
                                                + "where i.id = :data", Instructor.class);

    query.setParameter("data", theId);

    // execute query
    Instructor instructor = query.getSingleResult();

    return instructor;
}
```

File: `CruddemoApplication.java`:

```java
private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

    int theId = 1;

    // find the instructor
    // This code will still retrieve Instructor AND Courses
    System.out.println("Finding instructor id: " + theId);
    Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

    System.out.println("tempInstructor: " + tempInstructor);
    System.out.println("the associated courses: " + tempInstructor.getCourses());

    System.out.println("Done!");
}
```

## We have options now

- If you only need Instructor … and no courses, then call
  - `appDAO.findInstructorById(…)`
- If you need Instructor AND courses, then call
  - `appDAO.findInstructorByIdJoinFetch(…)`
- This gives us flexibility instead of having EAGER fetch hard-coded
