package com.employee.rest.kotlin.model

class Employee {

    var id:Long=0

    lateinit var firstName:String
    lateinit var lastName:String
    lateinit var email:String

    constructor(id:Long, firstName:String, lastName:String, email:String) {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }

}