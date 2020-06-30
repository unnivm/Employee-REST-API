package com.employee.rest.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class EmployeeKotlinApplication


fun main(args: Array<String>) {
	runApplication<EmployeeKotlinApplication>(*args)
}
