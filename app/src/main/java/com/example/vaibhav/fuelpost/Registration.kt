package com.example.vaibhav.fuelpost

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.vaibhav.fuelpost.domain.EmpMaster
import com.example.vaibhav.fuelpost.domain.UserResponse
import com.example.vaibhav.fuelpost.rest.ApiService
import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegister.setOnClickListener { registerEmp() }
    }

    private fun registerEmp() {

        val apiService = ApiService.create()
        val call = apiService
                .register(EmpMaster
                (
                        edtEmpId.text.toString(),
                        edtEmpName.text.toString(),
                        edtUserName.text.toString(),
                        edtPassword.text.toString(),
                        edtEmpStatus.text.toString()
                    )
                )
        call.enqueue(object : Callback<UserResponse> {

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                Log.i("@codekul", "error : ${t?.message}")
            }

            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                Log.i("@codekul", "response : ${response!!.body()!!.message}")

            }
        })
    }
}
