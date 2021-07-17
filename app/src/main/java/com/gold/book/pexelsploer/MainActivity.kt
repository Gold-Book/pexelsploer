package com.gold.book.pexelsploer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.lifecycleScope
import com.gold.book.pexelsploer.data.repository.PicturesRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<AppCompatButton>(R.id.test).setOnClickListener {
            lifecycleScope.launch {
                val response = PicturesRepository().search("sky")
                Timber.tag("test").d(response.toString())
            }
        }
    }
}
