package com.example.catpic.fullScreenFragment

import android.content.Context
import com.example.catpic.CatRepository
import com.example.catpic.ViewModelFactory
import com.example.catpic.retrofit.CatApi
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class FullScreenFragmentViewModelTest {
    private val viewModel = mockk<FullScreenFragmentViewModel>()
    private val context = mockk<Context>()
    private val url = ""
    @Before
    fun createDependencies() {
    }
    @Test
    fun checkPictureDownload() {
        verify { viewModel.downloadImage(url, context) }
    }

}
