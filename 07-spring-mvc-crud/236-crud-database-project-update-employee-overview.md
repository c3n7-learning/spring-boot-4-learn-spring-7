# CRUD Database Project - Update Employee - Overview

## Update Employee

1. "Update" button
2. Pre-populate the form
3. Process form data

### Step 1: "Update" Button

**Update** button includes employee id

- `(employeeId=${tempEmployee.id})}`: Appends to URL `?employeeId=xxx`

```html
<tr th:each="tempEmployee : ${employees}">
  <!-- … -->
  <td>
    <a
      th:href="@{/employees/showFormForUpdate(employeeId=${tempEmployee.id})}"
      class="btn btn-info btn-sm"
    >
      Update
    </a>
  </td>
</tr>
```

### Step 2: Pre-populate Form

Update the controller:

```java
@Controller
@RequestMapping("/employees")
public class EmployeeController {
  // …

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                  Model theModel) {

    // get the employee from the service
    Employee theEmployee = employeeService.findById(theId);

    // set employee as a model attribute to pre-populate the form
    theModel.addAttribute("employee", theEmployee);

    // send over to our form
    return "employees/employee-form";
  }
}
```

Update the form:

```html
<form
  action="#"
  th:action="@{/employees/save}"
  th:object="${employee}"
  method="POST"
>
  <!-- Add hidden form field to handle update -->
  <input type="hidden" th:field="*{id}" />
  <input
    type="text"
    th:field="*{firstName}"
    class="form-control mb-4 w-25"
    placeholder="First name"
  />
  <input
    type="text"
    th:field="*{lastName}"
    class="form-control mb-4 w-25"
    placeholder="Last name"
  />
  <input
    type="text"
    th:field="*{email}"
    class="form-control mb-4 w-25"
    placeholder="Email"
  />
  <button type="submit" class="btn btn-info col-2">Save</button>
</form>
```

### Step 3: Process form data to save employee

- No need for new code … we can reuse our existing code
- Works the same for add or update :-)

```java
@Controller
@RequestMapping("/employees")
public class EmployeeController {
  // …

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
    // save the employee
    employeeService.save(theEmployee);
    // use a redirect to prevent duplicate submissions
    return "redirect:/employees/list";
  }
}
```
