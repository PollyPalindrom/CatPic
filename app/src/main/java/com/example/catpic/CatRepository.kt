package com.example.catpic

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bumptech.glide.Glide
import com.example.catpic.databinding.FragmentFullScreenBinding
import com.example.catpic.databinding.ItemBinding
import com.example.catpic.pagination.CatPagingSource
import com.example.catpic.retrofit.CatApi
import com.example.catpic.retrofit.CatPic
import kotlinx.coroutines.flow.Flow


class CatRepository(val catApi: CatApi) {

    fun getCats(): Flow<PagingData<CatPic>> {
        return Pager(
            config = PagingConfig(
                pageSize = 50,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CatPagingSource(catApi) }
        ).flow
    }
}
