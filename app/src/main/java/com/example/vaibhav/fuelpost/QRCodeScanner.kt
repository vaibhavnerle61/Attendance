package com.example.vaibhav.fuelpost

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vaibhav.fuelpost.domain.EmpMaster
import com.example.vaibhav.fuelpost.rest.ApiService
import org.json.JSONException
import org.json.JSONObject
import com.google.zxing.integration.android.IntentIntegrator
import android.content.Intent
import android.util.Log
import android.view.View
import com.example.vaibhav.fuelpost.domain.EmpClockStatesResponse
import com.example.vaibhav.fuelpost.domain.EmpClockStats
import com.example.vaibhav.fuelpost.sherepreferences.Prefs
import kotlinx.android.synthetic.main.activity_qrcode_scanner.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class   QRCodeScanner : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode_scanner)
//
//         val  qrScan =  IntentIntegrator(this)
//
//                fab.setOnClickListener { qrScan.initiateScan() }
//
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show()
            } else {
                try {
                    val obj = JSONObject(result.contents)
                         } catch (e: JSONException) {
                    e.printStackTrace()

                    Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()

                    val empId=Prefs.getEmpId(applicationContext)
                    Log.i("@codekul","empId : $empId")

                    val apiService=ApiService.create()
                    val call=apiService.clockin(EmpClockStats(
                            empId,result.contents))
                    Log.i("@codekul","URL : ${call.request().url()}")

                    call.enqueue(object :Callback<EmpClockStatesResponse>{
                        override fun onFailure(call: Call<EmpClockStatesResponse>?, t: Throwable?) {
                            Log.i("@codekul","Error +${t?.message}")
                        }

                        override fun onResponse(call: Call<EmpClockStatesResponse>?, response: Response<EmpClockStatesResponse>?) {
                            Log.i("@codekul","response : ${response!!.body()!!.message}")
                        }

                    })

                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
