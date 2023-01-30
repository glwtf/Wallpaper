package com.example.wallpaper.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Hits(
    val id: Int,
    val previewURL: String,
    val largeImageURL: String,
    val fullHDURL: String = Response.UNKNOWN_STRING
)