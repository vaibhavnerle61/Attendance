package com.example.vaibhav.fuelpost.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.TextView
import com.example.vaibhav.fuelpost.R
import com.example.vaibhav.fuelpost.domain.EmpClockStatesResponse

/**
 * Created by vaibhav on 28/3/18.
 */
class DailyAdapter(private val list:ArrayList<EmpClockStatesResponse>,val context:Context): RecyclerView.Adapter<DailyAdapter.ViewHolder>() {

    private val fragment:Fragment?=null

        override fun getItemCount(): Int {
            return list.size
        }

    override fun onBindViewHolder(holder: DailyAdapter.ViewHolder?, position: Int) {

            holder?.setClockin_out()?.text="1"

    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DailyAdapter.ViewHolder{
        val v =LayoutInflater.from(parent?.context).inflate(R.layout.daily_record,parent,false)
        return ViewHolder(v)
    }


class ViewHolder(view: View):RecyclerView.ViewHolder(view){

//    fun bindItem(data:MyDataClass){
//
//        val _textView:TextView=itemView.findViewById(R.id.txtclockin)
//        val _textView1:TextView=itemView.findViewById(R.id.txtclockout)
//        val _imageView:ImageView=itemView.findViewById(R.id.imgclockin)
//        val _imageView2:ImageView=itemView.findViewById(R.id.imgclockout)
//        val _textview3:TextView=itemView.findViewById(R.id.sumofinout)
//
//        _textView.text=data.clockIn
//        _textView1.text=data.clockOut
//        _imageView.setImageResource(data.imageclockin)
//        _imageView2.setImageResource(data.imageclockout)
//        _textview3.text=data.sumclockin_out
//}


    fun setClockin_out():TextView{
        return   itemView.findViewById(R.id.txtclockin)



    }
}
}