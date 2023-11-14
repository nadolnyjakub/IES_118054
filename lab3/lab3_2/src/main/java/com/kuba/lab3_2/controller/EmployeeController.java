package com.kuba.lab3_2.controller;

import com.kuba.lab3_2.model.Employee;
import com.kuba.lab3_2.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long userId){
        Employee employee = employeeService.getEmployeeById(userId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long userId,
                                               @RequestBody Employee employee){
        employee.setId(userId);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long userId){
        employeeService.deleteEmployee(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("email")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathParam("email") String email){
        Employee employee = employeeService.getEmployeeByEmail(email);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}