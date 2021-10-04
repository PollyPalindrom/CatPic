package com.example.catpic.fullScreenFragment

import android.Manifest
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.catpic.CatApplication
import com.example.catpic.MainActivity
import com.example.catpic.R
import com.example.catpic.ViewModelFactory
import com.example.catpic.databinding.FragmentFullScreenBinding


class FullScreenFragment : Fragment() {

    private lateinit var binding: FragmentFullScreenBinding
    private val viewModel: FullScreenFragmentViewModel by viewModels {
        ViewModelFactory(((activity as MainActivity).getMyApplication() as CatApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFullScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val catUri = arguments?.getString(CAT_URI)
        val mainActivity = activity as MainActivity
        if (catUri != null) {
            loadPicture(catUri)
        }
        binding.apply {
            toolbar.title = getString(R.string.id) + arguments?.getString(CAT_ID)
            toolbar.setOnClickListener {
                mainActivity.supportFragmentManager.popBackStack()
            }
            save.setOnClickListener {
                if (catUri != null) {
                    if(isWritePermissionGranted()){
                        viewModel.downloadImage(catUri, requireContext())
                    } else {
                        askPermissions()
                    }
                }
            }
        }
        mainActivity.onBackPressedDispatcher.addCallback(mainActivity,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    mainActivity.supportFragmentManager.popBackStack()
                }
            })
    }

    private fun loadPicture(catUri: String) {
        Glide.with(binding.image.context)
            .load(catUri)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_android_24)
            .into(binding.image)
    }

    private fun isWritePermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireActivity(),
            WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun askPermissions() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(WRITE_EXTERNAL_STORAGE),
            REQUEST_CODE
        )
    }

    companion object {
        fun newInstance(catUri: String, id: String): FullScreenFragment =
            FullScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(CAT_URI, catUri)
                    putString(CAT_ID, id)
                }
            }

        private const val CAT_URI = "CAT_URI"
        private const val CAT_ID = "CAT_ID"
        private const val REQUEST_CODE = 100
    }
}
