package com.example.wallpaper.domain.usecase

import com.example.wallpaper.domain.WallpaperRepository

class GetThemeListUseCase(private val repository: WallpaperRepository) {

    operator fun invoke() = repository.getThemeList()
}