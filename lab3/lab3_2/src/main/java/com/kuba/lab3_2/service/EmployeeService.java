package com.kuba.lab3_2.service;

import com.kuba.lab3_2.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long userId);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long userId);

    Employee getEmployeeByEmail(String email);
}