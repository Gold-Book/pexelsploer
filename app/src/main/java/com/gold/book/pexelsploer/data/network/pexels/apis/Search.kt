package com.gold.book.pexelsploer.data.network.pexels.apis

import retrofit2.http.GET
import retrofit2.http.Query

interface Search {

    @GET("search")
    suspend fun find(
        @Query("query") query: String
    )
}
