package com.example.vaibhav.fuelpost.domain

/**
 * Created by vaibhav on 22/3/18.
 */
data class UserResponse(
        val status: String,
        val message: String,
        val result: EmpMaster
)

data class EmpClockStatesResponse(

        val status: String,
        val message: String,
        val result: List<EmpClockStats>


)

