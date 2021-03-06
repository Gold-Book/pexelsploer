package com.gold.book.pexelsploer.ui.top

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.gold.book.pexelsploer.data.entities.PhotoEntity
import com.gold.book.pexelsploer.databinding.TopPictureListItemBinding
import com.gold.book.pexelsploer.ui.top.views.PicturesViewHolder

class PicturesAdapter(
    private val viewModel: TopViewModel,
    private val listener: OnClickPictureViewListener
) : ListAdapter<PhotoEntity, PicturesViewHolder>(PicturesDiffCallBack()) {

    interface OnClickPictureViewListener {
        fun onClick(photoEntity: PhotoEntity)
    }

    override fun getItemCount(): Int = viewModel.photosLiveData.value?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PicturesViewHolder(TopPictureListItemBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: PicturesViewHolder, position: Int) {
        viewModel.getPhoto(position)?.let { entity ->
            holder.bindViewHolder(entity, viewModel)
            holder.itemView.setOnClickListener { listener.onClick(entity) }
        }
    }
}
