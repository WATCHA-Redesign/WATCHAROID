package com.yjooooo.watcharoid.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @BindingAdapter("setSrc")
    @JvmStatic
    fun setSrc(imageView: ImageView, imgId: Int) {
        imageView.setImageResource(imgId)
    }
}