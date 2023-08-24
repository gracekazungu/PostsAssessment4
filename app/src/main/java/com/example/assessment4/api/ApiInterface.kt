package com.example.assessment4.api

import com.example.assessment4.model.Post
import com.example.assessment4.model.PostResponse
import retrofit2.http.GET



import retrofit2.Response

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}
