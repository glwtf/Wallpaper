package com.example.wallpaper.presentation.recycleview

import androidx.recyclerview.widget.DiffUtil
import com.example.wallpaper.domain.entity.Response

class ThemeDiffCallBack: DiffUtil.ItemCallback<Response>() {
    override fun areItemsTheSame(oldItem: Response, newItem: Response): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Response, newItem: Response) = oldItem == newItem
}