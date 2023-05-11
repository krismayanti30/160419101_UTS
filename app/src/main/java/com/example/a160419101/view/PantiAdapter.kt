package com.example.a160419101.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419101.R
import com.example.a160419101.model.PantiAsuhan
import com.example.a160419101.util.progressLoad

class PantiAdapter (val pantiList:ArrayList<PantiAsuhan>)
    :RecyclerView.Adapter<PantiAdapter.PantiViewHolder>(){
    class PantiViewHolder (var view: View) : RecyclerView.ViewHolder(view)

    fun updatePantiList(newPantiList: ArrayList<PantiAsuhan>) {
        pantiList.clear()
        pantiList.addAll(newPantiList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PantiViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.panti_list_item, parent, false)
        return PantiViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pantiList.size
    }

    override fun onBindViewHolder(holder: PantiViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.textNamaPanti).text = pantiList[position].nama
        holder.view.findViewById<TextView>(R.id.textNamaKota).text = pantiList[position].alamat
        //holder.view.findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.opendonation)
        holder.view.findViewById<ImageView>(R.id.imagePantiPhoto).progressLoad("https://png.pngtree.com/png-clipart/20211223/ourmid/pngtree-box-icon-open-donation-and-contribution-png-image_4100853.png",holder.view.findViewById<ProgressBar>(R.id.progressLoadingPhotoPanti))
        holder.view.findViewById<Button>(R.id.btnDetail).setOnClickListener {
            Log.d("id",pantiList[position].no.toString())
            val action = fragment_panti_listDirections.actionPantiListToPantiDetail(pantiList[position].no.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
}
