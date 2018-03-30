package com.example.vaibhav.fuelpost.fragmemts


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.vaibhav.fuelpost.R
import com.example.vaibhav.fuelpost.adapter.DailyAdapter
import com.example.vaibhav.fuelpost.adapter.MyDataClass
import com.example.vaibhav.fuelpost.domain.EmpClockStatesResponse
import com.example.vaibhav.fuelpost.domain.EmpClockStats
import com.example.vaibhav.fuelpost.rest.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 */
class DailyFragment : Fragment() {

        val TAG:String="@codekul"
        private val item=ArrayList<MyDataClass>()


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_daily, container, false)
    }
    companion object {
        fun newInstance(): DailyFragment {
            val fragment = DailyFragment()
            return fragment
        }// Required empty public constructor
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler()
    }

    private fun recycler(){

        val rv=activity.findViewById<RecyclerView>(R.id.recyclerdaily)
        rv.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        val dailyrecord=ArrayList<EmpClockStatesResponse>()

        val apiService=ApiService.create()

        val call =apiService.clockin(EmpClockStats())

        call.enqueue(object : Callback<EmpClockStatesResponse>{
            override fun onFailure(call: Call<EmpClockStatesResponse>?, t: Throwable?) {

                Log.i(TAG, "Error : $t")

            }

            override fun onResponse(call: Call<EmpClockStatesResponse>?, response: Response<EmpClockStatesResponse>?) {

                val rr:EmpClockStatesResponse=response?.body()!!
                dailyrecord.add(rr)
                for (i in 0..rr.result.size) {
                    val adapter = DailyAdapter(dailyrecord, context)
                    rv.adapter = adapter
            }

            }



    })




//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//
//        val recyclerView: RecyclerView = activity.findViewById(R.id.recyclerdaily)
//
//        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
//
//        val apiService=ApiService.create()
//
//
//
//
//
//        item.add(MyDataClass("10:10 AM", "2:10 PM", R.drawable.ic_clock_in_arrow, R.drawable.ic_clock_out_arrow, "3:30"))
//
//        item.add(MyDataClass("2:10 AM", "4:33 PM", R.drawable.ic_clock_in_arrow, R.drawable.ic_clock_out_arrow, "2:30"))
//
//        item.add(MyDataClass("5:10 AM", "8:10 PM", R.drawable.ic_clock_in_arrow, R.drawable.ic_clock_out_arrow, "3:30"))
//
//        item.add(MyDataClass("10:10 AM", "2:10 PM", R.drawable.ic_clock_in_arrow, R.drawable.ic_clock_out_arrow, "3:30"))
//
//
//
//        val adapter = DailyAdapter(item)
//        recyclerView.adapter = adapter
//
//    }



}
}


