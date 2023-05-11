package com.example.a160419101.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.a160419101.R
import com.example.a160419101.viewmodel.ListViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_panti_list.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_panti_list : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val pantiAdapter = PantiAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_panti_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharePref = context?.getSharedPreferences("sharePref", Context.MODE_PRIVATE)
        val username = sharePref?.getString("username", null)
        if (username == null){
            findNavController().navigate(R.id.fragment_login)
        }
        val bottomView = activity?.findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomView?.visibility = View.VISIBLE
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        val recView = view.findViewById<RecyclerView>(R.id.recView)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = pantiAdapter
        observeViewModel()

        view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout).setOnRefreshListener {
            view.findViewById<RecyclerView>(R.id.recView).visibility = View.GONE
            view.findViewById<TextView>(R.id.textError).visibility = View.GONE
            view.findViewById<ProgressBar>(R.id.progressLoad).visibility = View.VISIBLE
            viewModel.refresh()
            view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout).isRefreshing = false
        }
    }

    private fun observeViewModel() {
        viewModel.pantiLD.observe(viewLifecycleOwner, Observer{
            pantiAdapter.updatePantiList(it)
        })
        viewModel.pantiLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view?.findViewById<TextView>(R.id.textError)
            if(it == true) {
                txtError?.visibility = View.VISIBLE
            } else {
                txtError?.visibility = View.GONE
            }
        })
        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoad)
            val recView = view?.findViewById<RecyclerView>(R.id.recView)
            if(it == true) {
                recView?.visibility = View.GONE
                progressLoad?.visibility = View.VISIBLE
            } else {
                recView?.visibility = View.VISIBLE
                progressLoad?.visibility = View.GONE
            }
        })
    }
}