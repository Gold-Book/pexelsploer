package com.gold.book.pexelsploer.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponseEntity(
    @Json(name = "photos") val photos: List<PhotoEntity>
)

@JsonClass(generateAdapter = true)
data class PhotoEntity(
    @Json(name = "id") val id: Long,
    @Json(name = "photographer") val photographer: String,
    @Json(name = "src") val src: SrcEntity
)

@JsonClass(generateAdapter = true)
data class SrcEntity(
    @Json(name = "portrait") val portrait: String,
    @Json(name = "small") val small: String
)
