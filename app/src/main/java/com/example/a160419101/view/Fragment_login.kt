package com.example.a160419101.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.a160419101.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_login.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_login : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomView = activity?.findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomView?.visibility = View.GONE
        val usernameLogin = view.findViewById<TextInputEditText>(R.id.inputUsernameLogin).text.toString()
        val passwordLogin = view.findViewById<TextInputEditText>(R.id.inputPasswordLogin).text.toString()
        val sharePref = context?.getSharedPreferences("sharePref", Context.MODE_PRIVATE)

        view.findViewById<TextView>(R.id.txtDaftar).setOnClickListener{
            val action = fragment_loginDirections.actionLoginToRegister()
            Navigation.findNavController(it).navigate(action)
        }
        view.findViewById<Button>(R.id.btnLogin).setOnClickListener {
            if (usernameLogin != "" && passwordLogin != "" ){
                val newUsername = sharePref?.getString("usernameLogin", null)
                val newPassword =sharePref?.getString("passwordLogin", null)
                if(usernameLogin == newUsername && passwordLogin == newPassword ){
                    val action = fragment_loginDirections.actionFragmentLoginToFragmentPantiList()
                    Navigation.findNavController(it).navigate(action)
                } else{
                    Toast.makeText(context, "Data Tidak Sesuai!", Toast.LENGTH_SHORT).show()
                }
            } else{
                val action = fragment_loginDirections.actionFragmentLoginToFragmentPantiList()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}