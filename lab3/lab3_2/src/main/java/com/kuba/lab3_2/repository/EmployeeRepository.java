package com.kuba.lab3_2.repository;



import com.kuba.lab3_2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getEmployeeByEmail(String email);

}