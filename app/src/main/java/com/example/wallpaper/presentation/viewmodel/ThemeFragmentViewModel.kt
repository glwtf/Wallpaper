package com.example.wallpaper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaper.data.WallpaperRepositoryImpl
import com.example.wallpaper.domain.usecase.GetThemeListUseCase
import com.example.wallpaper.domain.usecase.LoadThemesUseCase
import kotlinx.coroutines.launch

class ThemeFragmentViewModel : ViewModel() {

    private val repository = WallpaperRepositoryImpl

    private val loadThemesUseCase = LoadThemesUseCase(repository)
    private val getThemeListUseCase = GetThemeListUseCase(repository)

    init {
        viewModelScope.launch {
            loadThemesUseCase()
        }
    }

    val ldTheme = getThemeListUseCase()

}