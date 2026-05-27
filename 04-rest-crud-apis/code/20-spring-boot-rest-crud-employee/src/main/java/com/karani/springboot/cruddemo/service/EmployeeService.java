package com.karani.springboot.cruddemo.service;

import com.karani.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
