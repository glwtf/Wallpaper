package com.example.wallpaper.domain

import androidx.lifecycle.LiveData
import com.example.wallpaper.domain.entity.Response

interface WallpaperRepository {

    fun getThemeList(): LiveData<List<Response>> // show in mainfragment

    fun getImageList() //show in imagelist fragment

    fun getImage() //show in imagefragment

    fun setWallpaper() //work in imagefragment

    suspend fun loadThemes() //in spalsh time
}