package com.example.a160419101.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a160419101.R

/**
 * A simple [Fragment] subclass.
 * Use the [panti_list_item.newInstance] factory method to
 * create an instance of this fragment.
 */
class panti_list_item : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.panti_list_item, container, false)
    }
}