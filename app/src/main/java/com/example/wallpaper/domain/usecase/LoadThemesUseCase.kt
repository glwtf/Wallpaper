package com.example.wallpaper.domain.usecase

import com.example.wallpaper.domain.WallpaperRepository

class LoadThemesUseCase(private val repository: WallpaperRepository) {

    suspend operator fun invoke() =  repository.loadThemes()
}