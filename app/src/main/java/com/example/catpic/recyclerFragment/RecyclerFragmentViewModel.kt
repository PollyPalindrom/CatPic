package com.example.catpic.recyclerFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.example.catpic.CatRepository
import com.example.catpic.retrofit.CatPic

class RecyclerFragmentViewModel(repository: CatRepository) : ViewModel() {

    var cats: LiveData<PagingData<CatPic>> = repository.getCats().asLiveData()

}
