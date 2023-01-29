package com.example.wallpaper.presentation.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.wallpaper.databinding.ItemThemeBinding
import com.example.wallpaper.domain.entity.Response

class ThemeListAdapter(
    private val context: Context
): ListAdapter<
        Response,
        ThemeViewHolder
        >(ThemeDiffCallBack())
{
    var onThemeItemClickListener : ((Response) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        val binding = ItemThemeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ThemeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        val theme = getItem(position)
        val binding = holder.binding

        binding.tvThemeName.text = theme.themeName
        Glide
            .with(context)
            .load(theme.hits[0].previewURL)
            .into(binding.ivPreview)
        binding.root.setOnClickListener{
            onThemeItemClickListener?.invoke(theme)
        }
    }

}