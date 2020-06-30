package com.employee.rest.kotlin

import com.employee.rest.kotlin.model.Employee
import com.employee.rest.kotlin.repository.EmployeeRepository
import com.employee.rest.kotlin.service.EmployeeService
import com.employee.rest.kotlin.service.impl.EmployeeServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert

@SpringBootTest
class EmployeeKotlinApplicationTests {

	@Autowired
	private lateinit var employeeRepository:EmployeeRepository;

	private lateinit var employeeService: EmployeeService;

	@BeforeEach
	fun setup() {
		employeeService = EmployeeServiceImpl(employeeRepository)
	}

	@Test
	fun contextLoads() {
	}


	@Test
	fun whenEmployeeIsCreatedThenEmployeeIdShouldNotReturnNull() :Unit {
		val employee = Employee(0, "unni", "mana", "test@test.com")
		val savedEmployee = employeeService.createEmployee(employee)
		Assert.notNull(savedEmployee.id)
	}

	@Test
	fun whenEmployeeIsCreatedThenEmployeeCollectionShouldReturnAtLeastOne() : Unit {

		val employee = Employee(0, "unni", "mana", "test@test.com")
		val savedEmployee = employeeService.createEmployee(employee)
		Assert.isTrue(employeeService.getAllEmployee().size == 1)

	}

	@Test
	fun whenTwoEmployeesAreCreatedThenEmployeeCollectionShouldReturnThree() : Unit {

		var employee = Employee(0, "unni", "mana", "test@test.com")
		val savedEmployee = employeeService.createEmployee(employee)

		val employee2 = Employee(0, "abc", "def", "test@test.com")
		val secondEmployee = employeeService.createEmployee(employee2)

		Assert.isTrue(employeeService.getAllEmployee().size == 3)
	}


	@Test
	fun `employee name is empty -- should throw IllegalArguementException`() : Unit {
		val employee = Employee(0, "", "mana", "")
		assertThrows<IllegalArgumentException> { employeeService.createEmployee(employee) }
	}

	@Test
	fun `employee name is numeric -- should throw IllegalArguementException`() : Unit {
		val employee = Employee(0, "00000", "mana", "")
		assertThrows<IllegalArgumentException> { employeeService.createEmployee(employee) }
	}

	@Test
	fun `email does not contain period -- should throw IllegalArguementException`() : Unit {
		val employee = Employee(0, "unni", "mana", "abc@abc")
		assertThrows<IllegalArgumentException> { employeeService.createEmployee(employee) }
	}

}
