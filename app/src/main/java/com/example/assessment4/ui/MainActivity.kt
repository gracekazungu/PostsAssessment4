package com.example.assessment4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assessment4.R
import com.example.assessment4.api.ApiClient
import com.example.assessment4.api.ApiInterface
import com.example.assessment4.model.Post
import com.example.assessment4.viewmodel.PostViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()
    }

    fun getPosts() {
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(
                call: Call<List<Post>>, response:
                Response<List<Post>>
            ) {
                if (response.isSuccessful) {
                    var posts = response.body()
                    Toast.makeText(
                        baseContext, "${posts!!.size} posts", Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }
        })
    }
}

