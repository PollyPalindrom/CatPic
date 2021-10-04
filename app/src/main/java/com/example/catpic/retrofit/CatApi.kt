package com.example.catpic.retrofit

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatApi {

    @GET("search")
    suspend fun getListOfCats(
        @Header("x-api-key") key:String="160b11f3-2e79-4d16-ab4d-5fcfe7272c54",
        @Query("limit") limit:Int,
        @Query("page") page:Int,
        @Query("order") order:String ="Asc"
    ): List<CatPic>

}
