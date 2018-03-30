package com.example.vaibhav.fuelpost.fragmemts


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.vaibhav.fuelpost.R


/**
 * A simple [Fragment] subclass.
 */
class WeeklyFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_weekly, container, false)
    }
    companion object {
        fun newInstance():WeeklyFragment{
            val fragment=WeeklyFragment()
            return fragment
        }
    }



}// Required empty public constructor
