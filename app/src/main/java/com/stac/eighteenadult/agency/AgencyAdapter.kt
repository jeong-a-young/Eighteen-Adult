package com.stac.eighteenadult.agency

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.stac.eighteenadult.R

class AgencyAdapter (private val context : Activity, private val dataSet : List<Agency>) : RecyclerView.Adapter<AgencyAdapter.ViewHolder>() {

    val CALL_REQUEST_CODE = 1

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name : TextView
        val tv_address : TextView
        val iv_call : ImageView
        val iv_bookmark : ImageView
        val cv_image : CardView
        val iv_image : ImageView
        val v_view : View

        init {
            tv_name = view.findViewById(R.id.tv_name)
            tv_address = view.findViewById(R.id.tv_address)
            iv_call = view.findViewById(R.id.iv_call)
            iv_bookmark = view.findViewById(R.id.iv_bookmark)
            cv_image = view.findViewById(R.id.cv_image)
            iv_image = view.findViewById(R.id.iv_image)
            v_view = view.findViewById(R.id.v_view)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_agency_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tv_name.text = dataSet[position].name
        viewHolder.tv_address.text = dataSet[position].address

        viewHolder.iv_call.setOnClickListener {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.CALL_PHONE), CALL_REQUEST_CODE)
            } else {
                var intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:${dataSet[position].call}")
                context.startActivity(intent)
            }
        }

        setBookmark(position, viewHolder)
        viewHolder.iv_bookmark.setOnClickListener {
            dataSet[position].bookmark = !dataSet[position].bookmark
            setBookmark(position, viewHolder)
        }

        if (dataSet[position].image != 0) {
            viewHolder.iv_image.setImageResource(dataSet[position].image)
        } else {
            viewHolder.cv_image.visibility = View.INVISIBLE
        }

        if (position == dataSet.size - 1) {
            viewHolder.v_view.visibility = View.GONE
        }
    }

    private fun setBookmark(index : Int, viewHolder : ViewHolder) {
        if (dataSet[index].bookmark) {
            viewHolder.iv_bookmark.setImageResource(R.drawable.agency_icon_bookmark_on)
        } else {
            viewHolder.iv_bookmark.setImageResource(R.drawable.agency_icon_bookmark_off)
        }
    }

    override fun getItemCount() = dataSet.size
}