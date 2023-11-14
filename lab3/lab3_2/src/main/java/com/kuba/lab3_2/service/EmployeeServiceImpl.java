package com.kuba.lab3_2.service;

import com.kuba.lab3_2.model.Employee;
import com.kuba.lab3_2.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long userId) {
        Optional<Employee> optionalUser = employeeRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long userId) {
        employeeRepository.deleteById(userId);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        Employee employee = employeeRepository.getEmployeeByEmail(email);
        return employee;
    }
}