package com.achmadabrar.aruna_test.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.achmadabrar.aruna_test.R
import com.achmadabrar.aruna_test.data.model.Post

class PostsAdapter(
    val posts: List<Post>
): RecyclerView.Adapter<PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        posts[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}