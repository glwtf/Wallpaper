package com.example.wallpaper.domain.usecase

import com.example.wallpaper.domain.WallpaperRepository

class GetImageListUseCase(private val repository: WallpaperRepository) {

    operator fun invoke() = repository.getImageList()
}