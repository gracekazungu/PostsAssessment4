package com.example.assessment4.repository

import com.example.assessment4.api.ApiClient
import com.example.assessment4.api.ApiInterface
import com.example.assessment4.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response




class PostRepository {
    val apiClient= ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getPosts(): Response<List<Post>> {
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
        }
    }
}