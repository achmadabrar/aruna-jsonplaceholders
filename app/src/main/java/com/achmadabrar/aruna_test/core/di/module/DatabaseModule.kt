package com.achmadabrar.aruna_test.core.di.module

import android.app.Application
import androidx.room.Room
import com.achmadabrar.aruna_test.data.database.PostsDao
import com.achmadabrar.aruna_test.data.database.PostsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): PostsDatabase {
        return Room
            .databaseBuilder(application, PostsDatabase::class.java, PostsDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideUserDao(appDataBase: PostsDatabase): PostsDao {
        return appDataBase.postsDao()
    }
}