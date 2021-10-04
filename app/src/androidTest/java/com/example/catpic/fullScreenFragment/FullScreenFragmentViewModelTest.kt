package com.example.catpic.fullScreenFragment

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.catpic.CatRepository
import com.example.catpic.ViewModelFactory
import com.example.catpic.retrofit.CatApi
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(AndroidJUnit4::class)

class FullScreenFragmentViewModelTest {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/images/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val catApi: CatApi = retrofit.create(CatApi::class.java)
    val repository = CatRepository(catApi)
    val viewModel =
        ViewModelFactory(repository).create(FullScreenFragmentViewModel::class.java)

    @Test
    fun checkDownload() {
        viewModel.downloadImage(
            "https://ichef.bbci.co.uk/news/640/cpsprodpb/14A82/production/_116301648_gettyimages-1071204136.jpg",
            InstrumentationRegistry.getInstrumentation().targetContext
        )
    }
}
