package com.tech.employee_service.entity;

public record Employee(Long id, Long departmentId, String name, int age, String position) {
}
