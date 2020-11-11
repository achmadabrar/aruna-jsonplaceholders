package com.achmadabrar.aruna_test.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.achmadabrar.aruna_test.data.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(post: Post) {
        with(itemView) {
            title_post.text = post.title
            content_post.text = post.body
        }
    }

}