package com.example.catpic.retrofit

import com.google.gson.annotations.SerializedName


data class CatPic(
    @SerializedName("id") var id: String,
    @SerializedName("url") var url: String
)
