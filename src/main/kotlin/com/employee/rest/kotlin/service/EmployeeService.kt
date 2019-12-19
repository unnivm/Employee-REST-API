package com.employee.rest.kotlin.service

import com.employee.rest.kotlin.model.Employee

interface EmployeeService {
     public fun getAllEmployee() : MutableList<Employee>
     public fun createEmployee(employee: Employee)
 }