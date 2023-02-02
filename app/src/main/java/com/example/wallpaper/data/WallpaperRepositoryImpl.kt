package com.example.wallpaper.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wallpaper.domain.WallpaperRepository
import com.example.wallpaper.domain.entity.Hits
import com.example.wallpaper.domain.entity.Response

object WallpaperRepositoryImpl : WallpaperRepository {

    private var ldThemes = MutableLiveData<List<Response>>()
    private var ldImages = MutableLiveData<List<Hits>>()
    private var mapImages = mutableMapOf<String, List<Hits>>()

    override fun getThemeList() = ldThemes

    override fun getImageList(themeName : String) : LiveData<List<Hits>> {
        ldImages.value = mapImages[themeName]
        return ldImages
    }

    override suspend fun loadThemes(): Boolean {
        val loadThemes = LoadImageThemes()
        val themes = loadThemes()
        return if (themes.isNotEmpty()) {
            ldThemes.value = themes
            themes.forEach {
                mapImages += it.themeName to it.hits
            }
            true
        } else false
    }
}