package com.example.a160419101.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.a160419101.R

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_jenis_donasi.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_jenis_donasi : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jenis_donasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RadioGroup>(R.id.radioGroup).setOnCheckedChangeListener{
            group, checkId ->

            if(R.id.radioBtnMakanan == checkId){
                val action = fragment_jenis_donasiDirections.actionJenisDonasiToDonasiMakanan()
                Navigation.findNavController(group).navigate(action)
            } else if (R.id.radioBtnPakaian == checkId){
                val action = fragment_jenis_donasiDirections.actionJenisDonasiToDonasiPakaian()
                Navigation.findNavController(group).navigate(action)
            } else {
                val action = fragment_jenis_donasiDirections.actionJenisDonasiToDonasiUang()
                Navigation.findNavController(group).navigate(action)
            }
        }
    }
}