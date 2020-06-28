package com.employee.rest.kotlin.service.impl

import com.employee.rest.kotlin.model.Employee
import com.employee.rest.kotlin.repository.EmployeeRepository
import com.employee.rest.kotlin.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(val employeeRepository: EmployeeRepository) :EmployeeService {

    override fun getAllEmployee(): MutableList<Employee> {
        val emps = ArrayList<Employee>()
        for(emp in employeeRepository.findAll()) {
            val employee        = Employee(emp.id, emp.firstName, emp.lastName, emp.email )
            // add it to list
            emps.add(employee)
        }
        return emps
    }


    override fun createEmployee(employee: Employee) : Employee {
        val emp:com.employee.rest.kotlin.entity.Employee = com.employee.rest.kotlin.entity.Employee()

        // validate employee object
        validateEmployee(employee)

        emp.email     = employee.email
        emp.firstName = employee.firstName
        emp.lastName  = employee.lastName

        val savedEmp:com.employee.rest.kotlin.entity.Employee  = employeeRepository.save(emp)

        employee.id = savedEmp.id;

        return employee
    }

    /**
     * this method validates an employee object
     *
     */
    fun validateEmployee(employee: Employee) : Unit {
        if(employee.firstName.trim().equals("")) throw IllegalArgumentException()

        val regex = """.*\d.*""".toRegex()
        if(regex.matches(employee.firstName.trim())) throw IllegalArgumentException()
        if(regex.matches(employee.lastName.trim()))  throw IllegalArgumentException()
        if(!employee.email.contains("."))       throw IllegalArgumentException()
    }

}