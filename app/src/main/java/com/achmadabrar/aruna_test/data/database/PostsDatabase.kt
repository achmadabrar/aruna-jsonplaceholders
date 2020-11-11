package com.achmadabrar.aruna_test.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.achmadabrar.aruna_test.data.model.Post

@Database(
    entities = [Post::class],
    version = 1,
    exportSchema = true
)
abstract class PostsDatabase: RoomDatabase() {

    abstract fun postsDao(): PostsDao

    companion object {

        private var instance: PostsDatabase? = null
        private val LOCK = Any()
        const val DB_NAME = "posts.db"

        @JvmStatic
        fun getInstance(context: Context): PostsDatabase {
            synchronized(LOCK) {
                if (instance == null) {
                    instance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            PostsDatabase::class.java,
                            DB_NAME
                        )
                        .build()
                }
                return instance!!
            }
        }
    }
}