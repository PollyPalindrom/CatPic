package com.example.catpic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.catpic.fullScreenFragment.FullScreenFragmentViewModel
import com.example.catpic.recyclerFragment.RecyclerFragmentViewModel

class ViewModelFactory(private val repository: CatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecyclerFragmentViewModel::class.java)) {
            return RecyclerFragmentViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(FullScreenFragmentViewModel::class.java)) {
            return FullScreenFragmentViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
