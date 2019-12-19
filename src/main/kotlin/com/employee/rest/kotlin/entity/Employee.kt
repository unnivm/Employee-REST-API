package com.employee.rest.kotlin.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Employee {

     @Id
     @GeneratedValue
     var id:Long=0

     @Column
     lateinit var firstName:String
     @Column
     lateinit var lastName:String
     @Column
     lateinit var email:String

}