package com.example.wallpaper.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaper.data.WallpaperRepositoryImpl
import com.example.wallpaper.domain.usecase.LoadThemesUseCase
import kotlinx.coroutines.launch

class SplashFragmentViewModel(private val application: Application): ViewModel() {

    private var _ldProgression = MutableLiveData<Int>()
    val ldProgression: LiveData<Int>
        get() = _ldProgression

    private val repository = WallpaperRepositoryImpl
    private val loadThemesUseCase = LoadThemesUseCase(repository)

    init {
        loadThemes()
    }

    fun loadThemes() {
        _ldProgression.value = PROGRESS
        val isConnect = isNetworkAvailable(application)
        if (isConnect) {
            viewModelScope.launch {
                val isSuccess = loadThemesUseCase()
                if (isSuccess)
                    _ldProgression.value = READY
                else
                    _ldProgression.value = FAILED
            }
        }
        else
            _ldProgression.value = FAILED
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }

    companion object {
        const val FAILED = -1
        const val PROGRESS = 0
        const val READY = 1
    }
}