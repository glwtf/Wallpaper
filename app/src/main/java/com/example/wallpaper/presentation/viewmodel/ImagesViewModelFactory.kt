package com.example.wallpaper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ImagesViewModelFactory(
    private val themeName: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImagesFragmentViewModel::class.java)) {
            return ImagesFragmentViewModel(themeName) as T
        }
        throw java.lang.RuntimeException("Unknown view model class $modelClass")
    }
}