package com.example.catpic

import com.example.catpic.fullScreenFragment.FullScreenFragmentViewModel
import com.example.catpic.recyclerFragment.RecyclerFragmentViewModel
import com.example.catpic.retrofit.CatApi
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViewModelFactoryTest {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/images/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val catApi: CatApi = retrofit.create(CatApi::class.java)
    private val repository = CatRepository(catApi)

    @Test
    fun checkCreateFullScreenFragmentViewModel() {
        val viewModel =
            ViewModelFactory(repository).create(FullScreenFragmentViewModel::class.java)
        assertEquals(viewModel.javaClass, FullScreenFragmentViewModel::class.java)
    }

    @Test
    fun checkCreateRecyclerFragmentViewModel() {
        val viewModel =
            ViewModelFactory(repository).create(RecyclerFragmentViewModel::class.java)
        assertEquals(viewModel.javaClass, RecyclerFragmentViewModel::class.java)
    }
}
