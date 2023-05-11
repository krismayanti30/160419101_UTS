package com.example.a160419101.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.a160419101.R
import com.squareup.picasso.Picasso

fun ImageView.progressLoad(url: String?, progressBar:ProgressBar?) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.baseline_error_24)
        .into(this)
    progressBar?.visibility= View.GONE
}
