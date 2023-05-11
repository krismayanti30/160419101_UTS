package com.example.a160419101.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.a160419101.R

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_donasi_makanan.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_donasi_makanan : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donasi_makanan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnDonasiMakanan).setOnClickListener{
            Toast.makeText(context, "Donasi telah berhasil!",Toast.LENGTH_SHORT).show()
            val action = fragment_donasi_makananDirections.actionDonasiMakananToPantiList()
            Navigation.findNavController(it).navigate(action)
        }
    }
}