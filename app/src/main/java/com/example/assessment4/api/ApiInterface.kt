package com.example.assessment4.api

import com.example.assessment4.model.Post
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}