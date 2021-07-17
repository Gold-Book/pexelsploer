package com.gold.book.pexelsploer

import android.app.Application
import timber.log.Timber

class PexelsploerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}
