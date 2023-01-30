package com.example.wallpaper.presentation.fragment

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.wallpaper.databinding.FragmentSingleImageBinding


class SingleImageFragment : Fragment() {

    private val args by navArgs<SingleImageFragmentArgs>()

    private var _binding: FragmentSingleImageBinding? = null
    private val binding: FragmentSingleImageBinding
        get() = _binding ?: throw RuntimeException("ThemesFragment == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSingleImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImage()
        setOnClickListener()
    }

    private fun loadImage() {
        val image = binding.image
        Glide
            .with(this)
            .load(args.imageUrl)
            .into(image)
    }

    private fun setOnClickListener() {
        val wallpaperManager = WallpaperManager.getInstance(context)
        val setWallpaperButton = binding.btnSetWallpaper
        val imageView = binding.image

        setWallpaperButton.setOnClickListener {
            val bitmapImage = getBitmapFromView(imageView)
            wallpaperManager.setBitmap(bitmapImage)
            showToast()
        }
    }

    private fun getBitmapFromView(view: View): Bitmap {
        val bitmap = Bitmap.createBitmap(
            view.width, view.height, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }

    private fun showToast() {
        Toast.makeText(activity, "Image set as wallpaper success!", Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}