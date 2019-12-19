package com.employee.rest.kotlin.repository

import com.employee.rest.kotlin.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Long> {
}