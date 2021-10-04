package com.example.catpic.fullScreenFragment

import android.app.DownloadManager
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import androidx.lifecycle.ViewModel
import com.example.catpic.CatRepository
import com.example.catpic.MainActivity
import com.example.catpic.databinding.FragmentFullScreenBinding
import java.io.File

class FullScreenFragmentViewModel(private val repository: CatRepository) : ViewModel() {


    fun downloadImage(url: String, context: Context) {
        val filename = url.substringAfterLast("/")
        val request = DownloadManager.Request(Uri.parse(url))
            .setTitle(filename)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        (context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager)
            .enqueue(request)
    }
}
