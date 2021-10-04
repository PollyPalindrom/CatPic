package com.example.catpic.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.catpic.retrofit.CatApi
import com.example.catpic.retrofit.CatPic
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 0
private const val NEXT_PAGE = 1

class CatPagingSource(
    private val service: CatApi
) : PagingSource<Int, CatPic>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatPic> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.getListOfCats(page = position, limit = params.loadSize)
            val nextKey = if (response.isEmpty()) {
                null
            } else {
                position + NEXT_PAGE
            }
            LoadResult.Page(
                data = response,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CatPic>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
