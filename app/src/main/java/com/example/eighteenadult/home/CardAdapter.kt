package com.example.eighteenadult.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.eighteenadult.R

class CardAdapter (private val context: FragmentActivity?, private val dataSet: List<Card>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

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

        when(dataSet[position].title) {
            "일자리 정보" -> {
                viewHolder.cl_card.setOnClickListener {
//                    val intent = Intent(context, PrivacyPolicyActivity::class.java)
//                    context?.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount() = dataSet.size
}