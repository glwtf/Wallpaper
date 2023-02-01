package com.example.wallpaper.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaper.data.WallpaperRepositoryImpl
import com.example.wallpaper.domain.usecase.LoadThemesUseCase
import kotlinx.coroutines.launch

class SplashFragmentViewModel: ViewModel() {

    private var _ldProgression = MutableLiveData<Boolean>()
    val ldProgression: LiveData<Boolean>
        get() = _ldProgression

    private val repository = WallpaperRepositoryImpl
    private val loadThemesUseCase = LoadThemesUseCase(repository)

    init {
        _ldProgression.value = false
        viewModelScope.launch {
            // todo: add treatment of non connection
            loadThemesUseCase()
            _ldProgression.value = true
        }
    }

}