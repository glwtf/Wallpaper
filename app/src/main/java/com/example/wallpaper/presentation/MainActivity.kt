package com.example.wallpaper.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wallpaper.R
import com.example.wallpaper.presentation.fragment.ThemesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ThemesFragment())
            .addToBackStack(null)
            .commit()
    }

}