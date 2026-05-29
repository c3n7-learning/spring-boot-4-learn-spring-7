package com.karani.springboot.cruddemo.rest;

import com.karani.springboot.cruddemo.entity.Employee;
import com.karani.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    private JsonMapper jsonMapper;

    // If you only have one constructor, @Autowired is optional
    public EmployeeRestController(EmployeeService theEmployeeService, JsonMapper theJsonMapper) {
        employeeService = theEmployeeService;
        jsonMapper = theJsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // @RequestBody binds JSON to the Employee POJO

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        // if your employee is of type `int` you must use `.setId(0)`. That's what Hibernate will check
        // if using `Integer`, you must use `setId(null)`. That's what Hibernate will check
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String, Object> patchPayload) {

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        // id should not be part of the request body
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee, patchPayload);

        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
