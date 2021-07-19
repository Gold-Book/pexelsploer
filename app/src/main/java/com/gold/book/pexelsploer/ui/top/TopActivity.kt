package com.gold.book.pexelsploer.ui.top

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gold.book.pexelsploer.R
import com.gold.book.pexelsploer.data.entities.PhotoEntity
import com.gold.book.pexelsploer.databinding.TopActivityBinding
import com.gold.book.pexelsploer.ui.picture_detail.PictureDetailActivity
import com.gold.book.pexelsploer.ui.top.PicturesAdapter.OnClickPictureViewListener

class TopActivity : AppCompatActivity() {

    private val topViewModel: TopViewModel by viewModels()

    private lateinit var binding: TopActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.top_activity)

        binding.viewModel = topViewModel
        binding.lifecycleOwner = this
        binding.toolbarView.setLifeCycleOwner(this)

        binding.pictures.adapter = createAdapter()

        topViewModel.photosLiveData.observe(this) {
            if (it.isEmpty()) visibleEmptyPictures() else visiblePictures(it)
        }
    }

    private fun createAdapter(): PicturesAdapter {
        return PicturesAdapter(topViewModel, object : OnClickPictureViewListener {
            override fun onClick(photoEntity: PhotoEntity) {
                val intent = PictureDetailActivity.createStartIntent(
                    this@TopActivity, photoEntity.src.portrait
                )

                startActivity(intent)
            }
        })
    }

    private fun visibleEmptyPictures() {
        binding.emptyPictures.visibility = VISIBLE
        binding.pictures.visibility = GONE
    }

    private fun visiblePictures(entities: List<PhotoEntity>) {
        binding.emptyPictures.visibility = GONE
        binding.pictures.visibility = VISIBLE

        (binding.pictures.adapter as PicturesAdapter).submitList(entities)
    }
}
