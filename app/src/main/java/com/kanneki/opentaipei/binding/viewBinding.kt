package com.kanneki.opentaipei.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.kanneki.opentaipei.R

@BindingAdapter("loadUrl")
fun loadUrlAdapter(view: ImageView, url: String){

    view.load(url){
        crossfade(true)
        error(R.drawable.ic_baseline_priority_high_24)
    }
}