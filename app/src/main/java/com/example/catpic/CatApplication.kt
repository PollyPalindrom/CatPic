package com.example.catpic

import android.app.Application
import com.example.catpic.retrofit.CatApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatApplication : Application() {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/images/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var catApi: CatApi = retrofit.create(CatApi::class.java)
    val repository by lazy { CatRepository(catApi) }
}