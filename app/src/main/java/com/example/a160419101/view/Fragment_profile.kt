package com.example.a160419101.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.a160419101.R
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_profile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharePref = context?.getSharedPreferences("sharePref", Context.MODE_PRIVATE)
        val usernameProfile = sharePref?.getString("username", null).toString()
        val passwordProfile = sharePref?.getString("password", null).toString()
        view.findViewById<TextInputEditText>(R.id.editUsername).setText(usernameProfile)
        view.findViewById<TextInputEditText>(R.id.oldPassword).setText(passwordProfile)
        view.findViewById<TextInputEditText>(R.id.newPassword).setText(passwordProfile)
    }
}