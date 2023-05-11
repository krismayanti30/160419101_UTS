package com.example.a160419101.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.a160419101.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_register.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_register : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = view.findViewById<TextInputEditText>(R.id.inputUsername).text
        val password = view.findViewById<TextInputEditText>(R.id.inputPassword).text
        val repeatPassword = view.findViewById<TextInputEditText>(R.id.inputRepeatPassword).text
        view.findViewById<Button>(R.id.btnRegister).setOnClickListener{
            //Log.d("Test", username +""+ password +""+ repeatPassword)
            Toast.makeText(context,password, Toast.LENGTH_SHORT).show()
            if (username.toString().isNotEmpty()  && password.toString().isNotEmpty() && repeatPassword.toString().isNotEmpty()){
                if(password.toString() == repeatPassword.toString()){
                    val sharePref = context?.getSharedPreferences("sharePref", Context.MODE_PRIVATE)
                    val editor = sharePref?.edit()
                    editor?.apply {
                        putString("username",username.toString())
                        putString("password", password.toString())
                        apply()
                    }
                    val action = fragment_registerDirections.actionRegisterToLogin()
                    Navigation.findNavController(it).navigate(action)
                } else{
                    Toast.makeText(context, "Passowrd Tidak Sesuai!", Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(context, "Data Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show()
            }
        }
        view.findViewById<TextView>(R.id.txtMasuk).setOnClickListener{
        val action = fragment_registerDirections.actionRegisterToLogin()
        Navigation.findNavController(it).navigate(action)
        }
    }
}
