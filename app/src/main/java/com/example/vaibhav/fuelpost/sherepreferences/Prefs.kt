package com.example.vaibhav.fuelpost.sherepreferences

import android.content.Context
import android.content.SharedPreferences
import com.google.zxing.Result

/**
 * Created by vaibhav on 24/3/18.
 */
class Prefs{

    companion object {

        private const val USER="User"
        private const val EMP_ID="empId"

        fun saveEmpId(context: Context,empId:String){

            val sharedPreferences:SharedPreferences=context.getSharedPreferences(USER,Context.MODE_PRIVATE)

            val editor=sharedPreferences.edit()

            editor.putString(EMP_ID,empId).apply()

        }


        fun getEmpId(context: Context):String{
            val sharedPreferences:SharedPreferences=context.getSharedPreferences(USER,Context.MODE_PRIVATE)
            return sharedPreferences.getString(EMP_ID,null)

        }
    }


}