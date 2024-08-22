package com.tech.department_service.controller;

import com.tech.department_service.client.EmployeeClient;
import com.tech.department_service.entity.Department;
import com.tech.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping("/saveDepartment")
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/getAllDepartments")
    public List<Department> findAll() {
        LOGGER.info("Departments find");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        LOGGER.info("Department find: id={}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employee")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Departments with employees");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department ->
                department.setEmployees(employeeClient.findEmployeesByDepartmentId(department.getId())));

        return departments;
    }

}
