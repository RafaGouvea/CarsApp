package com.example.orgs.extensions

import android.widget.ImageView
import coil.load
import com.example.orgs.R

fun ImageView.loadImgView(url: String? = null){
    load(url){
        fallback(R.drawable.ic_launcher_background)
        error(R.drawable.ic_launcher_background)
        placeholder(R.drawable.ic_launcher_background)
    }
}