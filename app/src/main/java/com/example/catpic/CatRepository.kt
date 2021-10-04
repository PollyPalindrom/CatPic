package com.example.catpic

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.catpic.pagination.CatPagingSource
import com.example.catpic.retrofit.CatApi
import com.example.catpic.retrofit.CatPic
import kotlinx.coroutines.flow.Flow


class CatRepository(val catApi: CatApi) {

    fun getCats(): Flow<PagingData<CatPic>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CatPagingSource(catApi) }
        ).flow
    }
}
