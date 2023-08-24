package com.example.assessment4.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.example.assessment4.databinding.ActivityMainBinding
import com.example.assessment4.model.PostAdapter
import com.example.assessment4.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {
    val postsViewModel: PostViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    lateinit var postsAdapter: PostAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()


        postsViewModel.fetchPosts()

        postsViewModel.postsLiveData.observe(
            this,
            Observer { postsList ->
                val postsAdapter = PostAdapter(postsList ?: emptyList())
                binding.recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
                binding.recyclerView.adapter = postsAdapter
            })

        postsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })


    }
}









