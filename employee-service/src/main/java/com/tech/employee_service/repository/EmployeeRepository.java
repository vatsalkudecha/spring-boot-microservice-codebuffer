package com.tech.employee_service.repository;

import com.tech.employee_service.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findEmployeeById(Long id) {
        return employees.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAllEmployees() {
        return employees;
    }

    public List<Employee> findEmployeesByDepartmentId(Long departmentId) {
        return employees.stream()
                .filter(employee -> employee.departmentId().equals(departmentId))
                .toList();
    }

}
