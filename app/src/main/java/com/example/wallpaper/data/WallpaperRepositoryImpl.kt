package com.example.wallpaper.data

import android.util.Log
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


    override fun getImage() {
        TODO("Not yet implemented")
    }

    override fun setWallpaper() {
        TODO("Not yet implemented")
    }

    override suspend fun loadThemes() {
        val loadThemes = LoadImageThemes()
        val themes = loadThemes()
        ldThemes.value = themes
        themes.forEach {
            mapImages += it.themeName to it.hits
        }
    }
}