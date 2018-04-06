package com.example.vaibhav.fuelpost.fragmemts


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.vaibhav.fuelpost.R


/**
 * A simple [Fragment] subclass.
 */
class CustomFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_custom, container, false)

    }

    companion object {
        fun newInstance():CustomFragment{
            val fragment=CustomFragment()
            return fragment
        }
    }

}// Required empty public constructor
