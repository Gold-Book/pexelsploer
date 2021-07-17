package com.gold.book.pexelsploer.data.network.pexels

import com.gold.book.pexelsploer.data.network.pexels.HttpClient.Companion.apiV1
import com.gold.book.pexelsploer.data.network.pexels.apis.Pictures

object Endpoints {
    fun pictures(): Pictures = apiV1.create(Pictures::class.java)
}
