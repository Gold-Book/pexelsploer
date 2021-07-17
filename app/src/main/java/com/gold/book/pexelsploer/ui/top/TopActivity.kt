package com.gold.book.pexelsploer.ui.top

import android.os.Bundle
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

        with(binding.toolbarView) {
            setLifeCycleOwner(this@TopActivity)
        }
    }
}
