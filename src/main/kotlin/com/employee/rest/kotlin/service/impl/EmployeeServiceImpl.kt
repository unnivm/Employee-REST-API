package com.employee.rest.kotlin.service.impl

import com.employee.rest.kotlin.model.Employee
import com.employee.rest.kotlin.repository.EmployeeRepository
import com.employee.rest.kotlin.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl :EmployeeService {

    @Autowired
    lateinit var  employeeRepository:EmployeeRepository

    override fun getAllEmployee(): MutableList<Employee> {
        val emps = ArrayList<Employee>()
        for(emp in employeeRepository.findAll()) {
            val employee        = Employee(emp.id, emp.firstName, emp.lastName, emp.email )
            // add it to list
            emps.add(employee)
        }
        return emps
    }


    override fun createEmployee(employee: Employee) {
        val emp:com.employee.rest.kotlin.entity.Employee = com.employee.rest.kotlin.entity.Employee()

        emp.email     = employee.email
        emp.firstName = employee.firstName
        emp.id        = employee.id
        emp.lastName  = employee.lastName

        employeeRepository.save(emp)
    }

}