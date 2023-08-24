package com.example.assessment4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assessment4.api.ApiInterface
import com.example.assessment4.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel(private val apiInterface: ApiInterface) : ViewModel() {

    val postsLiveData: MutableLiveData<List<Post>?> = MutableLiveData()

    fun getPosts() {
        val request = apiInterface.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    postsLiveData.postValue(posts)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }
        })
    }
}

