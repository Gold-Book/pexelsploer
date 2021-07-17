package com.gold.book.pexelsploer.ui.top.views

import androidx.recyclerview.widget.RecyclerView
import com.gold.book.pexelsploer.data.entities.PhotoEntity
import com.gold.book.pexelsploer.databinding.TopPictureListItemBinding
import com.gold.book.pexelsploer.ui.top.TopViewModel

class PicturesViewHolder(
    private val binding: TopPictureListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindViewHolder(photo: PhotoEntity, viewModel: TopViewModel) {
        binding.photo = photo
        binding.viewModel = viewModel
    }
}
