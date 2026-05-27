# Changing Index of Mysql Auto Increment

- What if we want our id to start at a value like 3000?

```sql
ALTER TABLE student_tracker.student AUTO_INCREMENT=3000;
```

- How do I reset the AutoIncrement values back to 1?

```sql
TRUNCATE student_tracker.student;
```
