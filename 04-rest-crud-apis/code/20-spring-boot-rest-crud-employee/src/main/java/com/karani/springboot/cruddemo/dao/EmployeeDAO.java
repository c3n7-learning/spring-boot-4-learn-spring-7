package com.karani.springboot.cruddemo.dao;

import com.karani.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
