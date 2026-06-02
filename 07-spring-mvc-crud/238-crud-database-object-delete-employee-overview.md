# CRUD Database Project - Delete Employee - Overview

## Delete Employee

1. Add “Delete” button/link on page
2. Add controller code for "Delete"

## Step 1: "Delete" button

- Delete button includes employee id

```html
<tr th:each="tempEmployee : ${employees}">
  <!-- … -->
  <td>
    ?employeeId=xxx
    <a
      th:href="@{/employees/delete(employeeId=${tempEmployee.id})}"
      class="btn btn-danger btn-sm"
      onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false"
    >
      Delete
    </a>
  </td>
</tr>
```

## Step 2: Add controller code for delete

```java
@Controller
@RequestMapping("/employees")
public class EmployeeController {
  // …
  @GetMapping("/delete")
  public String delete(@RequestParam("employeeId") int theId) {

    // delete the employee
    employeeService.deleteById(theId);

    // redirect to /employees/list
    return "redirect:/employees/list";
  }
  // …
}
```
