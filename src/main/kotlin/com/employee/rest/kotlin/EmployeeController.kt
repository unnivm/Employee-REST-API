package com.employee.rest.kotlin

import com.employee.rest.kotlin.model.Employee
import com.employee.rest.kotlin.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/employees")
class EmployeeController(val employeeService: EmployeeService) {


    @GetMapping("/", produces = arrayOf("application/json"))
    fun getEAllEmployees() :List<Employee> {
        return employeeService.getAllEmployee()
    }

    @PostMapping("/", consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
    fun createEmployee(@RequestBody employee:Employee) :ResponseEntity<Object> {
        employeeService.createEmployee(employee)

        val location: URI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.id)
                .toUri()

        return ResponseEntity.created(location).build()
    }

}

