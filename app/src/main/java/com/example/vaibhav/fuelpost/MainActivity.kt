package com.example.vaibhav.fuelpost

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.vaibhav.fuelpost.domain.EmpMaster
import com.example.vaibhav.fuelpost.domain.UserResponse
import com.example.vaibhav.fuelpost.rest.ApiService
import com.example.vaibhav.fuelpost.sherepreferences.Prefs
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private val TAG = "@codekul"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            postdata()

        }
    }

    private fun postdata() {

        val apiService = ApiService.create()

        val call = apiService.login(EmpMaster(0,"","",edtUserName.text.toString(),edtPassword.text.toString(),""))
        Log.i(TAG, "URL: ${call.request().url()}")
        call.enqueue(object : Callback<UserResponse> {

            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                Log.i("@codekul", "response : ${response!!.body()!!.message}")



                if (response.code() == 200) {

                    if (response.body()?.status == "success") {

                        Prefs.saveEmpId(applicationContext, response.body()!!.result.empId)

                        Log.i(TAG, "EmpId:${response.body()!!.result.empId}")


                        Log.i(TAG, "status : ${response.body()?.status}")
                        val intent = Intent(applicationContext, Attendance::class.java)
                        startActivity(intent)
                    } else Log.i(TAG, "status : ${response.body()?.status}")
                }

            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                Log.i(TAG, "error : ${t?.message}")
            }
        })

    }
}



