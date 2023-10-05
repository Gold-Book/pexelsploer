package com.gold.book.pexelsploer.ui.top

import androidx.recyclerview.widget.DiffUtil
import com.gold.book.pexelsploer.data.entities.PhotoEntity

class PicturesDiffCallBack : DiffUtil.ItemCallback<PhotoEntity>() {

    override fun areItemsTheSame(oldItem: PhotoEntity, newItem: PhotoEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PhotoEntity, newItem: PhotoEntity): Boolean {
        return oldItem.id == newItem.id
    }
}
