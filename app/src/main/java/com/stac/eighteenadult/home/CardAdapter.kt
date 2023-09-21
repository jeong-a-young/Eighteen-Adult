package com.stac.eighteenadult.home

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.eighteenadult.R
import com.stac.eighteenadult.information.InformationActivity

class CardAdapter (private val context : Activity, private val dataSet : List<Card>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cl_card : ConstraintLayout
        val et_info : TextView
        val et_title : TextView
        val iv_ico : ImageView

        init {
            cl_card = view.findViewById(R.id.cl_card)
            et_info = view.findViewById(R.id.et_info)
            et_title = view.findViewById(R.id.et_title)
            iv_ico = view.findViewById(R.id.iv_ico)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_home_information, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.et_info.text = dataSet[position].info
        viewHolder.et_title.text = dataSet[position].title
        viewHolder.iv_ico.setImageResource(dataSet[position].icon)

        viewHolder.cl_card.setOnClickListener {
            val intent = Intent(context, InformationActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataSet.size
}