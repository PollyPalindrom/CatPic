package com.example.catpic.fullScreenFragment

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.catpic.managers.CatPictureDownloadManager


class FullScreenFragmentViewModel : ViewModel() {
    private val manager: CatPictureDownloadManager = CatPictureDownloadManager()
    fun downloadImage(url: String, context: Context) {
        manager.downloadImage(url, context)
    }
}
