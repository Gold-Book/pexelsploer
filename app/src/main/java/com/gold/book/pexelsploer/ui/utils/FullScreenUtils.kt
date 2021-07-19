package com.gold.book.pexelsploer.ui.utils

import android.os.Build
import android.os.Build.VERSION_CODES.R
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_TOUCH

object FullScreenUtils {
    // see: https://developer.android.com/training/system-ui/immersive.html
    fun hideSystemUi(window: Window) {
        if (Build.VERSION.SDK_INT < R) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                    // Set the content to appear under the system bars so that the
                    // content doesn't resize when the system bars hide and show.
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    // Hide the nav bar and status bar
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
        } else {
            val hideTypes = WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars()

            window.insetsController?.hide(hideTypes)
            window.insetsController?.systemBarsBehavior = BEHAVIOR_SHOW_BARS_BY_TOUCH
        }
    }
}
