package com.gold.book.pexelsploer.data.repository

import com.gold.book.pexelsploer.data.network.pexels.Endpoints.pictures
import com.gold.book.pexelsploer.data.network.pexels.entities.SearchResponseEntity

class PicturesRepository {

    suspend fun search(keyword: String): SearchResponseEntity {
        return pictures().search(keyword)
    }
}
