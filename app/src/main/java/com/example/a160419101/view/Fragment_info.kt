package com.example.a160419101.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a160419101.R

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_info.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_info : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }
}