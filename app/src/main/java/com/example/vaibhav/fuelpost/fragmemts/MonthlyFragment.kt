package com.example.vaibhav.fuelpost.fragmemts


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vaibhav.fuelpost.R
import kotlinx.android.synthetic.main.monthly_record.*
import com.example.vaibhav.fuelpost.adapter.ExpndableList



/**
 * A simple [Fragment] subclass.
 */
class MonthlyFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_monthly, container, false)
    }


    companion object {
        fun newInstance():MonthlyFragment{
            val fragment=MonthlyFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("@codekul","oncreate")
        val  listHeader = listOf("Number","fruits")

        val numberList= listOf("one","two","three","four")

        val fruitlist= listOf("Apple","Banana")

        val listchild=HashMap<String,List<String>>()
        listchild.put(listHeader[0],numberList)
        listchild.put(listHeader[1],fruitlist)

        explst.setAdapter(ExpndableList(context,listHeader,listchild))
    }
}
