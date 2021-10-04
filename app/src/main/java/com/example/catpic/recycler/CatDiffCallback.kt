package com.example.catpic.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.catpic.retrofit.CatPic

class CatDiffCallback : DiffUtil.ItemCallback<CatPic>() {
    override fun areItemsTheSame(oldItem: CatPic, newItem: CatPic): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CatPic, newItem: CatPic): Boolean {
        return oldItem.url == newItem.url
    }
}