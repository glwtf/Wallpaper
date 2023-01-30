package com.example.wallpaper.data

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import com.example.wallpaper.domain.entity.Response
import io.ktor.client.call.*
import io.ktor.client.request.*

class LoadImageThemes {

    private val js = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
        explicitNulls = false
    }

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(js)
        }
    }

    suspend operator fun invoke() : List<Response> {
        val themeList = mutableListOf<Response>()
        urlDictionary.forEach { url_theme ->
            val response = client.get(url_theme.value).body<Response>()
            response.themeName = url_theme.key
            themeList.add(response)
        }
        return themeList
    }

    companion object {

        private val urlDictionary = mapOf(
            "flower" to "https://pixabay.com/api/?key=33106230-b104905cd7ff74ed17e2229af&q=flowers&image_type=all",
            "car" to "https://pixabay.com/api/?key=33106230-b104905cd7ff74ed17e2229af&q=racing+car&image_type=photo",
            "animals" to "https://pixabay.com/api/?key=33106230-b104905cd7ff74ed17e2229af&q=jungle+animals&image_type=photo",
            "city" to "https://pixabay.com/api/?key=33106230-b104905cd7ff74ed17e2229af&q=usa+city&image_type=photo",
            "spiderman" to "https://pixabay.com/api/?key=33106230-b104905cd7ff74ed17e2229af&q=spider-man&image_type=all",
            "films" to "https://pixabay.com/api/?key=33106230-b104905cd7ff74ed17e2229af&q=films&image_type=photo"
        )
    }

}