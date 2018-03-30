package com.example.vaibhav.fuelpost

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class CalenderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)

        supportActionBar?.title="Calender"
    }
}

