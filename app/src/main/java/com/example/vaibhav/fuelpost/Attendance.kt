package com.example.vaibhav.fuelpost

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.vaibhav.fuelpost.fragmemts.CustomFragment
import com.example.vaibhav.fuelpost.fragmemts.DailyFragment
import com.example.vaibhav.fuelpost.fragmemts.MonthlyFragment
import com.example.vaibhav.fuelpost.fragmemts.WeeklyFragment
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_attendance.*
import kotlinx.android.synthetic.main.app_bar_attendance.*

class Attendance : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val TAG:String="@codekul"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)
        setSupportActionBar(toolbar)

        Log.i(TAG,"In attendance activity")

        val  qrScan =  IntentIntegrator(this)

        fabCamera.setOnClickListener { qrScan.initiateScan() }


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.attendance, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

         return when (item.itemId) {
            R.id.daily -> {
                val fragment=DailyFragment.newInstance()
                replaceFragment(fragment)
                true
            }

             R.id.weekly ->{
                 val fragment=WeeklyFragment.newInstance()
                 replaceFragment(fragment)
                 true
             }

             R.id.monthly ->{

                 val fragment=MonthlyFragment.newInstance()
                 replaceFragment(fragment)
                 true
             }

             R.id.custom ->{

                 val fragment=CustomFragment.newInstance()
                 replaceFragment(fragment)
                 true
             }

             else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.attendance -> {
                val fragment=DailyFragment.newInstance()
                replaceFragment(fragment)
                true


            }
            R.id.profile -> {

                val intent = Intent(applicationContext,ProfileActivity::class.java)
                startActivity(intent)

            }
            R.id.melayerCalender -> {

                val intent = Intent(applicationContext,CalenderActivity::class.java)
                startActivity(intent)

            }
            R.id.feedback -> {

            }
            R.id.logout -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

       private fun replaceFragment(fragment: android.support.v4.app.Fragment){


        val fragmentTransaction= supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container1,fragment)
        fragmentTransaction.commit()
     }



 }
