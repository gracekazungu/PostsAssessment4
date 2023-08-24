package com.example.assessment4.viewmodel


//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.assessment4.model.Post
//import com.example.assessment4.repository.PostRepository
//import kotlinx.coroutines.launch
//
//class PostViewModel :ViewModel(){
//    var productsRepo= PostRepository()
//    val productsLiveData= MutableLiveData<List<Post>>()
//    val errorLiveData= MutableLiveData<String>()
//
//    fun fetchProducts(){
//        viewModelScope.launch{
//            val response=productsRepo.getProducts()
//            if(response.isSuccessful){
//                productsLiveData.postValue(response.body()?.post)
//            }
//            else{
//                errorLiveData.postValue(response.errorBody()?.string())
//            }
//        }
//    }
//}
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment4.model.Post
import com.example.assessment4.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel:ViewModel (){
    var postsRepo= PostRepository()
    var postsLiveData= MutableLiveData<List<Post>>()
    var errorLiveData= MutableLiveData<String>()

    fun fetchPosts(){
        viewModelScope.launch{
            val response=postsRepo.getPosts()
            if(response.isSuccessful){

                val postsList = response.body() ?: emptyList()
                postsLiveData.postValue(postsList as
                        List<Post>)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}