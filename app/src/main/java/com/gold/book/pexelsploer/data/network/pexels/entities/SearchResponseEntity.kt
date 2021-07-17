package com.gold.book.pexelsploer.data.network.pexels.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponseEntity(
    @Json(name = "photos") val photos: PhotoEntity
)

@JsonClass(generateAdapter = true)
data class PhotoEntity(
    @Json(name = "src") val src: SrcEntity
)

@JsonClass(generateAdapter = true)
data class SrcEntity(
    @Json(name = "original") val original: String,
    @Json(name = "small") val small: String
)
