package com.example.wallpaper.domain

import androidx.lifecycle.LiveData
import com.example.wallpaper.domain.entity.Hits
import com.example.wallpaper.domain.entity.Response

interface WallpaperRepository {

    fun getThemeList(): LiveData<List<Response>> // show in mainfragment

    fun getImageList(themeName : String) : LiveData<List<Hits>> //show in imagelist fragment

    suspend fun loadThemes(): Boolean //in spalsh time
}