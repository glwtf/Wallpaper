package com.example.wallpaper.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    var themeName: String = UNKNOWN_STRING,
    val total: Int,
    val totalHits: Int,
    val hits: List<Hits>
)
{
    @Serializable
    class Hits(
     val id: Int,
     val previewURL: String,
     val largeImageURL: String,
     val fullHDURL: String = UNKNOWN_STRING
    )

    companion object {
        const val UNKNOWN_STRING = ""
    }
}