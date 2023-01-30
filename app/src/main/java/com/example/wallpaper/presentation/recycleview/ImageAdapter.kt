package com.example.wallpaper.presentation.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.wallpaper.databinding.ItemImagesBinding
import com.example.wallpaper.domain.entity.Hits

class ImageAdapter(private val context: Context): Adapter<ImageViewHolder>() {

    var imageGallery = listOf<Hits>()
    var onImageItemClickListener : ((Hits) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImagesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = imageGallery[position]
        val binding = holder.binding

        Glide
            .with(context)
            .load(image.previewURL)
            .into(binding.ivImage)
        binding.root.setOnClickListener {
            onImageItemClickListener?.invoke(image)
        }
    }

    override fun getItemCount() = imageGallery.size
}