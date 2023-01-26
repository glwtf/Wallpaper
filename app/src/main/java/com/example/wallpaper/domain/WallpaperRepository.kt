package com.example.wallpaper.domain

interface WallpaperRepository {

    fun getThemeList() //in spalsh time show in mainfragment

    fun getImageList() //show in imagelist fragment

    fun getImage() //show in imagefragment

    fun setWallpaper() //work in imagefragment
}