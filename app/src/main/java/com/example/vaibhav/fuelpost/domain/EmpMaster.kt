package com.example.vaibhav.fuelpost.domain

/**
 * Created by vaibhav on 22/3/18.
 */
data class EmpMaster(
         var id: Long = 0,
         var empId: String="",
         var empName: String="",
         var userName: String="",
         var password: String="",
         var empStatus: String=""
)