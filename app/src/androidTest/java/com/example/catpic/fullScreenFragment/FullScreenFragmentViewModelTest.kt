package com.example.catpic.fullScreenFragment

import android.content.Context
import com.example.catpic.managers.CatPictureDownloadManager
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class FullScreenFragmentViewModelTest {
    private val viewModel = FullScreenFragmentViewModel()
    private val downloadManager = mockk<CatPictureDownloadManager>(relaxed = true)
    private val context = mockk<Context>(relaxed = true)

    @Test
    fun checkPictureDownload() {
        viewModel.downloadImage("пока", context)
        verify { downloadManager.downloadImage("пока", context) }
    }

}
