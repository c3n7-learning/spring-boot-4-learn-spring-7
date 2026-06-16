# @OneToMany - Update Instructor

## Update Instructor

- Find an instructor by ID
- Change the instructor’s data by calling setter method(s)
- Update the instructor using the DAO

## Add new DAO method to update instructor

- `merge(…)` will update an existing entity

```java
@Override
@Transactional
public void update(Instructor tempInstructor) {
    entityManager.merge(tempInstructor);
}
```

## Main app

File: `CruddemoApplication.java`

```java
private void updateInstructor(AppDAO appDAO) {
    int theId = 1;

    System.out.println("Finding instructor id: " + theId);
    Instructor tempInstructor = appDAO.findInstructorById(theId);

    System.out.println("Updating instructor id: " + theId);
    tempInstructor.setLastName("TESTER");

    appDAO.update(tempInstructor);

    System.out.println("Done");
}
```
