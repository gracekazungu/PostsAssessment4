package com.example.assessment4.repository


import com.example.assessment4.api.ApiInterface
import com.example.assessment4.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository(private val apiInterface: ApiInterface) {

    fun getPosts(callback: (List<Post>?, Throwable?) -> Unit) {
        val request = apiInterface.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    callback(posts, null)
                } else {
                    callback(null, Throwable("Response not successful"))
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                callback(null, t)
            }
        })
    }
}





