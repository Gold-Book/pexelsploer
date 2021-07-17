package com.gold.book.pexelsploer.ui.top

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gold.book.pexelsploer.R
import com.gold.book.pexelsploer.databinding.TopActivityBinding

class TopActivity : AppCompatActivity() {

    private val topViewModel: TopViewModel by viewModels()

    private lateinit var binding: TopActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.top_activity)

        binding.viewModel = topViewModel
        binding.lifecycleOwner = this

        binding.toolbarView.setLifeCycleOwner(this)
        binding.pictures.adapter = PicturesAdapter(topViewModel)

        topViewModel.photosLiveData.observe(this) {
            if (it.isEmpty()) {
                binding.emptyPictures.visibility = VISIBLE
                binding.pictures.visibility = GONE
                return@observe
            }

            binding.emptyPictures.visibility = GONE
            binding.pictures.visibility = VISIBLE

            (binding.pictures.adapter as PicturesAdapter).submitList(it)
        }
    }
}
