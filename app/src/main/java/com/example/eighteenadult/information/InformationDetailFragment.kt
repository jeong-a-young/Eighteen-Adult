package com.example.eighteenadult.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.eighteenadult.MainActivity
import com.example.eighteenadult.R

class InformationDetailFragment : Fragment() {

    private var viewGroup: ViewGroup? = null

    lateinit var btn_back : ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewGroup = inflater.inflate(R.layout.fragment_information_detail, container, false) as ViewGroup?

        btn_back = viewGroup?.findViewById(R.id.btn_back)!!
        btn_back.setOnClickListener {
            val mainActivity = (activity as MainActivity)
            mainActivity.changeFragment(2)
        }

        return viewGroup
    }
}