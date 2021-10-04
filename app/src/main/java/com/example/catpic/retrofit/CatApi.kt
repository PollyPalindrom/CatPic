package com.example.catpic.retrofit

import retrofit2.http.GET

interface CatApi {

    @GET("search?api-key=160b11f3-2e79-4d16-ab4d-5fcfe7272c54&&limit=10")
    suspend fun getListOfCats(): List<CatPic>

}