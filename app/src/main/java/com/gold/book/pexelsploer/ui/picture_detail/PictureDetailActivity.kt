package com.gold.book.pexelsploer.ui.picture_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gold.book.pexelsploer.R
import com.gold.book.pexelsploer.databinding.PictureDetailActivityBinding
import com.gold.book.pexelsploer.ui.utils.FullScreenUtils.hideSystemUi

class PictureDetailActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_URL_KEY = " EXTRA_URL_KEY"

        fun createStartIntent(context: Context, url: String) =
            Intent(context, PictureDetailActivity::class.java).apply {
                putExtra(EXTRA_URL_KEY, url)
            }
    }

    private lateinit var binding: PictureDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.picture_detail_activity)
        binding.imageUrl = intent.getStringExtra(EXTRA_URL_KEY)

        hideSystemUi(window)
    }
}
