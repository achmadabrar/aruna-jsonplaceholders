package com.achmadabrar.aruna_test.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")
data class Post(
    val body: String,
    @PrimaryKey val id: Int,
    val title: String,
    val userId: Int
)