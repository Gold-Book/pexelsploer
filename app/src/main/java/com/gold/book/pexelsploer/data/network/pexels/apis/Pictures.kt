package com.gold.book.pexelsploer.data.network.pexels.apis

import com.gold.book.pexelsploer.data.entities.SearchResponseEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface Pictures {

    @GET("search")
    suspend fun search(
        @Query("query") query: String
    ): SearchResponseEntity
}
