package com.example.wallpaper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wallpaper.data.WallpaperRepositoryImpl
import com.example.wallpaper.domain.usecase.GetImageListUseCase

class ImagesFragmentViewModel(private val themeName: String) : ViewModel() {

    private val repository = WallpaperRepositoryImpl

    private val getImageListUseCase = GetImageListUseCase(repository)

    val ldImages = getImageListUseCase(themeName)

}