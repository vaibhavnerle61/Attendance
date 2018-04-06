package com.example.vaibhav.fuelpost.adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.vaibhav.fuelpost.R

/**
 * Created by vaibhav on 4/4/18.
 */
class ExpndableList(private val context:Context, val listofHeaderData:List<String>, val lisofchildData:HashMap<String,List<String>>) : BaseExpandableListAdapter() {

    override fun getGroup(position: Int): Any {

        return listofHeaderData[position]
    }

    override fun isChildSelectable(headerPosition: Int, childposition: Int): Boolean {

        return true

    }

    override fun hasStableIds(): Boolean {

        return false
    }


    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {

        val headerTitle=getGroup(groupPosition) as String

        val view:View= LayoutInflater.from(context).inflate(R.layout.list_group_month,parent,false)

        val listHeaderText=view.findViewById<TextView>(R.id.txtlistgroup) as TextView

        listHeaderText.setTypeface(null,Typeface.BOLD)
        listHeaderText.text=headerTitle
        return view
    }

    override fun getChildrenCount(groupPosition: Int): Int {

        return lisofchildData[listofHeaderData[groupPosition]]!!.size

    }

    override fun getChild(groupPosition:Int, childposition:Int): Any {

        return lisofchildData[listofHeaderData[groupPosition]]!![childposition]

    }

    override fun getGroupId(groupPosition: Int): Long {

       return  groupPosition.toLong()

    }

    override fun getChildView(groupPosition: Int, childposition: Int, isLastchild: Boolean, convertView: View?, parent: ViewGroup?): View {

        val childtext=getChild(groupPosition,childposition) as String
        val view:View=LayoutInflater.from(context).inflate(R.layout.list_item_month,parent,false)
        val listItemText=view.findViewById<TextView>(R.id.txtlistitem) as TextView
        listItemText.text=childtext
        return view

    }

    override fun getChildId(groupPosition: Int, childposition: Int): Long {

        return childposition.toLong()

    }

    override fun getGroupCount(): Int {

       return listofHeaderData.size

    }

}

