package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    // spring data JPA will parse the method name
    // looks for a specific format and pattern. Creates appropriate query ... behind the scenes
    // findAllBy   OrderByLastNameAsc
    // https://www.luv2code.com/query-methods
    public List<Employee> findAllByOrderByLastNameAsc();
}
