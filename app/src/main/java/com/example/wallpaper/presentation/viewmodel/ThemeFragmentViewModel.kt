package com.example.wallpaper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wallpaper.data.WallpaperRepositoryImpl
import com.example.wallpaper.domain.usecase.GetThemeListUseCase

class ThemeFragmentViewModel : ViewModel() {

    private val repository = WallpaperRepositoryImpl

    private val getThemeListUseCase = GetThemeListUseCase(repository)

    val ldTheme = getThemeListUseCase()

}