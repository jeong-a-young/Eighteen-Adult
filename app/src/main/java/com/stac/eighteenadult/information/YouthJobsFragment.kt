package com.stac.eighteenadult.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eighteenadult.R

class YouthJobsFragment : Fragment() {

    private var viewGroup: ViewGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewGroup = inflater.inflate(R.layout.fragment_youth_jobs, container, false) as ViewGroup?
        return viewGroup
    }
}