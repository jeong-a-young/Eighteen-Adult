package com.stac.eighteenadult.entire

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eighteenadult.R

class EntireAdapter (private val context : Activity, private val dataSet : List<Entire>) : RecyclerView.Adapter<EntireAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv_icon : ImageView
        val tv_name : TextView

        init {
            iv_icon = view.findViewById(R.id.iv_icon)
            tv_name = view.findViewById(R.id.tv_name)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_entire_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.iv_icon.setImageResource(dataSet[position].icon)
        viewHolder.tv_name.text = dataSet[position].name
    }

    override fun getItemCount() = dataSet.size
}