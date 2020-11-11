package com.achmadabrar.aruna_test.data.database

import androidx.room.*
import com.achmadabrar.aruna_test.data.model.Post

@Dao
@TypeConverters(PostListConverter::class)
interface PostsDao {
    @Query("SELECT * FROM posts_table")
    suspend fun getAllPosts(): List<Post>?

    @Query("SELECT * FROM posts_table WHERE `title` == :title ")
    suspend fun getPostBytitle(title: String?): Post?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(listProduct: List<Post>)
}