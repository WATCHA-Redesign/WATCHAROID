package com.yjooooo.watcharoid.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @BindingAdapter("setSrc")
    @JvmStatic
    fun setSrc(imageView: ImageView, imgId: Int) {
        imageView.setImageResource(imgId)
    }

    @BindingAdapter("setPediaNum", "setPediaWatcher")
    @JvmStatic
    fun setPediaWatcher(textView: TextView, num: String, watcher: String) {
        val txt = watcher + "님 외 $num 명 시청 중"
        textView.text = txt
    }
}