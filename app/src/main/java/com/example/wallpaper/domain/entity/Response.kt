package com.example.wallpaper.domain.entity

class Response(
    val total: Int,
    val totalHits: Int,
    val hits: List<Hits>
)
{
    class Hits(
     val id: Int,
     val previewURL: String,
     val largeImageURL: String,
     val fullHDURL: String
    )
}