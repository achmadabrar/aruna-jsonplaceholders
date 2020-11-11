package com.achmadabrar.aruna_test.data.database

import androidx.room.TypeConverter
import com.achmadabrar.aruna_test.data.model.Post
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PostListConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun mutableListToString(string: MutableList<Post>): String {
            val type = object : TypeToken<MutableList<Post>>() {}.type
            return Gson().toJson(string, type)
        }

        @TypeConverter
        @JvmStatic
        fun stringToMutableList(string: String): MutableList<Post> {
            val type = object : TypeToken<MutableList<Post>>() {}.type
            return Gson().fromJson(string, type)
        }
    }
}