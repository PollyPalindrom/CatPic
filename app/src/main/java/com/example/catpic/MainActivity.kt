package com.example.catpic

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.catpic.databinding.ActivityMainBinding
import com.example.catpic.fullScreenFragment.FullScreenFragment
import com.example.catpic.recyclerFragment.RecyclerFragment

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        if (savedInstanceState == null) openRecyclerFragment()
    }

    private fun openRecyclerFragment() {
        val recyclerFragment = RecyclerFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, recyclerFragment).commit()
    }

    fun flipCard(catUri: String, id: String) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.animator.flip_in_right,
                R.animator.flip_out_fight,
                R.animator.flip_in_left,
                R.animator.flip_out_left
            )
            .replace(R.id.container, FullScreenFragment.newInstance(catUri, id))
            .addToBackStack(null)
            .commit()
    }

    fun getMyApplication(): Application? {
        return application
    }
}