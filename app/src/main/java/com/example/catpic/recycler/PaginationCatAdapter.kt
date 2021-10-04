package com.example.catpic.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.catpic.CatListener
import com.example.catpic.databinding.ItemBinding
import com.example.catpic.retrofit.CatPic

class PaginationCatAdapter(private val listener: CatListener) :
    PagingDataAdapter<CatPic, CatViewHolder>(CatDiffCallback()) {
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), listener
        )
    }
}