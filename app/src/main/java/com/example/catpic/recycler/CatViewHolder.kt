package com.example.catpic.recycler

import androidx.lifecycle.LifecycleObserver
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catpic.CatListener
import com.example.catpic.R
import com.example.catpic.databinding.ItemBinding
import com.example.catpic.retrofit.CatPic


class CatViewHolder(
    private val binding: ItemBinding,
    private val listener: CatListener
) :
    RecyclerView.ViewHolder(binding.root), LifecycleObserver {

    fun bind(catPic: CatPic) {

        Glide.with(binding.image.context)
            .load(catPic.url)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_android_24)
            .into(binding.image)

        setListener(catPic)
    }

    private fun setListener(catPic: CatPic) {
        binding.image.setOnClickListener {
            catPic.id?.let { it1 -> catPic.url?.let { it2 -> listener.cardFlip(it2, it1) } }
        }
    }

}