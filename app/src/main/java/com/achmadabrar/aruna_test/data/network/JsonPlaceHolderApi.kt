package com.achmadabrar.aruna_test.data.network

import com.achmadabrar.aruna_test.data.model.PostsResponse
import retrofit2.http.GET

interface JsonPlaceHolderApi {

    companion object {
        private const val POSTS = "posts"
    }

    @GET(POSTS)
    suspend fun getPosts(): PostsResponse
}