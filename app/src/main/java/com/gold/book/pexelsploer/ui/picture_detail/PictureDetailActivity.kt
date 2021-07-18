package com.gold.book.pexelsploer.ui.picture_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gold.book.pexelsploer.R
import com.gold.book.pexelsploer.databinding.PictureDetailActivityBinding

class PictureDetailActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_URL_KEY = " EXTRA_URL_KEY"
        private const val EXTRA_PHOTOGRAPHER_KEY = " photographer"

        fun createStartIntent(context: Context, url: String, photographer: String) =
            Intent(context, PictureDetailActivity::class.java).apply {
                putExtra(EXTRA_URL_KEY, url)
                putExtra(EXTRA_PHOTOGRAPHER_KEY, photographer)
            }
    }

    private lateinit var binding: PictureDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.picture_detail_activity)

        binding.imageUrl = intent.getStringExtra(EXTRA_URL_KEY)
        binding.photographer = intent.getStringExtra(EXTRA_PHOTOGRAPHER_KEY)
    }
}
