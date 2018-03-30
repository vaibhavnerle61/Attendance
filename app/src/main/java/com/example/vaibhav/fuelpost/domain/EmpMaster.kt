package com.example.vaibhav.fuelpost.domain

/**
 * Created by vaibhav on 22/3/18.
 */
class EmpMaster() {
     var id: Long = 0
    lateinit var empId: String
    lateinit var empName: String
    lateinit var userName: String
    lateinit var password: String
    lateinit var empStatus: String

    constructor(empId : String,empName:String,userName: String,password: String,empStatus :String):this(){

        this.empId = empId
        this.empName=empName
        this.userName=userName
        this.password=password
        this.empStatus=empStatus

    }

    constructor(userName: String,password: String):this(){

        this.userName=userName
        this.password=password
    }


}