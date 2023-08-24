package com.example.assessment4.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment4.databinding.ItemPostBinding

class PostAdapter (private var postsLists:List<Post>):RecyclerView.Adapter<PostsViewHolder>(){
    lateinit var binding: ItemPostBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding=ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return postsLists.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentPost=postsLists[position]
        val binding=holder.binding
        binding.tvUserId.text=currentPost.userId.toString()
        binding.tvId.text=currentPost.id.toString()
        binding.tvTitle.text=currentPost.title
        binding.tvBody.text=currentPost.body

    }
}


class PostsViewHolder(var binding: ItemPostBinding):RecyclerView.ViewHolder(binding.root)