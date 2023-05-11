package com.example.a160419101.model

import com.google.gson.annotations.SerializedName

data class PantiAsuhan(
    @SerializedName("No")
    val no:String?,
    @SerializedName("Alamat Panti Asuhan")
    val alamat:String?,
    @SerializedName("Nama Panti Asuhan")
    val nama:String,
    @SerializedName("Jumlah Anak Asuh")
    val jumlahAnakAsuh:String,
    @SerializedName("Jumlah Pengurus")
    val jumlahPengurus:String
)