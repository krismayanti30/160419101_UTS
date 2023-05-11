package com.example.a160419101.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160419101.R
import com.example.a160419101.util.progressLoad
import com.example.a160419101.viewmodel.DetailPanti
import com.example.a160419101.viewmodel.ListViewModel
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_panti_detail.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_panti_detail : Fragment() {
    private lateinit var viewModel: DetailPanti

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_panti_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailPanti::class.java)
        if (arguments != null){
            val idPanti = fragment_panti_detailArgs.fromBundle(requireArguments()).id
            viewModel.getDetail(idPanti)
            Log.d("Test",idPanti)
        }
        observeViewModel()
        view.findViewById<Button>(R.id.btnDetail).setOnClickListener{
            val action = fragment_panti_detailDirections.actiaonPantiDetailToJenisDonasi()
            Navigation.findNavController(it).navigate(action)
        }
    }

    private fun observeViewModel() {
        viewModel.pantiLD.observe(viewLifecycleOwner, Observer{
            view?.findViewById<TextView>(R.id.textDeskripsi)?.text =
                "Nama Panti Asuhan: ${it.nama} " +
                                "\n Alamat: ${it.alamat}"+
                                "\n Jumlah Anak Asuh: ${it.jumlahAnakAsuh} " +
                                "\n Jumlah Pengurus: ${it.jumlahPengurus}"
            view?.findViewById<ImageView>(R.id.imagePantiDetail)?.progressLoad("https://png.pngtree.com/png-clipart/20211223/ourmid/pngtree-box-icon-open-donation-and-contribution-png-image_4100853.png",null)
        })
    }
}