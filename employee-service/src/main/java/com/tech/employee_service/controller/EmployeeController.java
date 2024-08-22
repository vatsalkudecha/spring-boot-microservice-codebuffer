package com.tech.employee_service.controller;

import com.tech.employee_service.entity.Employee;
import com.tech.employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        LOGGER.info("Employee added: {}", employee);
        return employeeRepository.add(employee);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        LOGGER.info("All employees");
        return employeeRepository.findAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable Long id) {
        LOGGER.info("Employee by id:{}", id);
        return employeeRepository.findEmployeeById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeesByDepartmentId(@PathVariable Long departmentId) {
        LOGGER.info("All employees by department-id:{}", departmentId);
        return employeeRepository.findEmployeesByDepartmentId(departmentId);
    }

}
