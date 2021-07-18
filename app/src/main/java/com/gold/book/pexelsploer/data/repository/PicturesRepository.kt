package com.gold.book.pexelsploer.data.repository

import com.gold.book.pexelsploer.data.entities.SearchResponseEntity
import com.gold.book.pexelsploer.data.network.pexels.Endpoints.pictures

class PicturesRepository {

    companion object {
        private const val PICTURE_PER_PAGE = 20
    }

    suspend fun search(keyword: String): SearchResponseEntity {
        return pictures().search(keyword, PICTURE_PER_PAGE)
    }
}
