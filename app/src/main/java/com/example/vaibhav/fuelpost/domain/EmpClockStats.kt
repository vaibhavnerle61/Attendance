package com.example.vaibhav.fuelpost.domain

/**
 * Created by vaibhav on 24/3/18.
 */
class EmpClockStats (){

    var id : Long =0
    lateinit var empId: String
    lateinit var clockIn :String
    lateinit var clockOut : String

    lateinit var doorKey :String


    constructor(empId :String,doorKey :String):this(){

        this.empId=empId
        this.doorKey=doorKey
    }




}
