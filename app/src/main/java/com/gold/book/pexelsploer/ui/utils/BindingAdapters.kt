package com.gold.book.pexelsploer.ui.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.gold.book.pexelsploer.GlideApp

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun imageUrl(imageView: AppCompatImageView, url: String?) {
        GlideApp.with(imageView.context).load(url).centerCrop().into(imageView)
    }
}
