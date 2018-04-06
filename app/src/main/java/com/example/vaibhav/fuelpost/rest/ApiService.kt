package com.example.vaibhav.fuelpost.rest

import com.example.vaibhav.fuelpost.domain.EmpClockStatesResponse
import com.example.vaibhav.fuelpost.domain.EmpClockStats
import com.example.vaibhav.fuelpost.domain.EmpMaster

import com.example.vaibhav.fuelpost.domain.UserResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by vaibhav on 22/3/18.
 */
interface ApiService {


    @Headers("Accept:Application/json",
            "Content-Type:Application/json")

    @POST("emp/login")
    fun login(@Body empMaster: EmpMaster): Call<UserResponse>

    @POST("emp")
    fun register(@Body empMaster: EmpMaster): Call<UserResponse>

    @POST("empclockstats")
    fun clockin(@Body empClockStats: EmpClockStats):Call<EmpClockStatesResponse>


    companion object {

        private const val PROTOCOL: String = "http"
        private const val SERVER: String = "192.168.0.104"
        private const val PORT: String = "8092"
        private const val APP_NAME: String = "api"
        private const val BASE_URL = "$PROTOCOL://$SERVER:$PORT/$APP_NAME/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}