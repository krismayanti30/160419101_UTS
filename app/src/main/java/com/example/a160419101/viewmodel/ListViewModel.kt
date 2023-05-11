package com.example.a160419101.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160419101.model.PantiAsuhan
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel(application: Application): AndroidViewModel(application){
    val pantiLD = MutableLiveData<ArrayList<PantiAsuhan>>()
    val pantiLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue:RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        pantiLoadErrorLD.value = false
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://satudata.kuburayakab.go.id/dataset/6274d090-20d1-41b0-ab84-550340c1cfbc/resource/fa793009-4729-4401-aee6-9f569d72daa7/download/data-panti-asuhan-di-kabupaten-kubu-raya.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<PantiAsuhan>>() { }.type
                val result = Gson().fromJson<ArrayList<PantiAsuhan>>(it, sType)
                //val pantiList:ArrayList<PantiAsuhan> = arrayListOf<PantiAsuhan>()
                pantiLD.value = result
                loadingLD.value = false
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
                pantiLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}
