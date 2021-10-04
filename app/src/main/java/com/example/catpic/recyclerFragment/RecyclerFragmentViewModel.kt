package com.example.catpic.recyclerFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.catpic.CatRepository
import com.example.catpic.databinding.ItemBinding
import com.example.catpic.retrofit.CatPic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecyclerFragmentViewModel(private val repository: CatRepository) : ViewModel() {

    var cats: LiveData<PagingData<CatPic>> = repository.getCats().asLiveData()

}
