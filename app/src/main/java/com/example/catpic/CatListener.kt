package com.example.catpic

import com.example.catpic.databinding.ItemBinding

interface CatListener {
    fun loadPicture(binding: ItemBinding, catUri: String)
    fun cardFlip(catUri: String, id: String)
}