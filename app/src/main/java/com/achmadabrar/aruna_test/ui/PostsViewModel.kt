package com.achmadabrar.aruna_test.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.achmadabrar.aruna_test.core.base.BaseViewModel
import com.achmadabrar.aruna_test.data.database.PostsDao
import com.achmadabrar.aruna_test.data.model.Post
import com.achmadabrar.aruna_test.data.network.JsonPlaceHolderApi
import com.achmadabrar.aruna_test.data.network.NetworkState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    val jsonPlaceHolderApi: JsonPlaceHolderApi,
    val postsDao: PostsDao
): BaseViewModel<PostsViewModel>() {

    var networkLiveData: MutableLiveData<NetworkState> = MutableLiveData()
    var postsLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    private val supervisorJob = SupervisorJob()

    init {
        loadPosts()
    }

    fun loadPosts() {
        ioScope.launch( getJobErrorHandler() + supervisorJob) {
            val cache = postsDao.getAllPosts()
            if (cache.isNullOrEmpty()) {
                val posts = jsonPlaceHolderApi.getPosts()
                postsLiveData.postValue(posts)
                postsDao.insertPosts(posts)
                val data = postsDao.getAllPosts()
                Log.d("post in db", "$data")
            } else {
                postsLiveData.postValue(cache)
            }

        }
    }

    fun searchByTitle(query:String?) {
        ioScope.launch {
            val posts = postsDao.getPostBytitle(query)
            val newList = mutableListOf<Post>()
            newList.add(posts!!)
            postsLiveData.postValue(newList)
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        Log.e(PostsViewModel::class.simpleName, "An error happened: $e")
        networkLiveData.postValue(NetworkState.fialed(e.localizedMessage))
        networkLiveData.postValue(NetworkState.FAILED)
    }
}