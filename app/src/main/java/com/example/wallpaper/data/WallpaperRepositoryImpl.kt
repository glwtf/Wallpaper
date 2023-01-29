package com.example.wallpaper.data

import androidx.lifecycle.MutableLiveData
import com.example.wallpaper.domain.WallpaperRepository
import com.example.wallpaper.domain.entity.Response

object WallpaperRepositoryImpl : WallpaperRepository {

    private var ldTheme = MutableLiveData<List<Response>>()

    override fun getThemeList() = ldTheme

    override fun getImageList() {
        TODO("Not yet implemented")
    }

    override fun getImage() {
        TODO("Not yet implemented")
    }

    override fun setWallpaper() {
        TODO("Not yet implemented")
    }

    override suspend fun loadThemes() {
        val themes = LoadImageTheme()
        ldTheme.value = themes()
    }
}