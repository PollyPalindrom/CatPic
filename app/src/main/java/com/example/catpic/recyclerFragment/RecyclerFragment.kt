package com.example.catpic.recyclerFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.catpic.*
import com.example.catpic.databinding.FragmentRecyclerBinding
import com.example.catpic.databinding.ItemBinding
import com.example.catpic.fullScreenFragment.FullScreenFragment
import com.example.catpic.recycler.PaginationCatAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RecyclerFragment : Fragment(), CatListener {

    private var binding: FragmentRecyclerBinding? = null
    private val catAdapter = PaginationCatAdapter(this)
    private val viewModel: RecyclerFragmentViewModel by viewModels {
        ViewModelFactory(((activity as MainActivity).getMyApplication() as CatApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recycler?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = catAdapter
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.cats.observe(viewLifecycleOwner) {
                catAdapter.submitData(lifecycle, it)
            }
        }
    }

    override fun loadPicture(binding: ItemBinding, catUri: String) {
        Glide.with(binding.image.context)
            .load(catUri)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_android_24)
            .into(binding.image)
    }

    override fun cardFlip(catUri: String, id: String) {
        (activity as MainActivity).flipCard(catUri, id)
    }

    companion object {
        fun newInstance(): RecyclerFragment =
            RecyclerFragment()
    }
}
