package com.employee.rest.kotlin

import com.employee.rest.kotlin.model.Employee
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private lateinit var restTemplate: TestRestTemplate


    @Test
    fun testForHttpStatus200WhenEmployeeCollectionIsEmpty() : Unit {
        val entity = restTemplate.getForEntity<List<Employee>>("/employees/")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

}