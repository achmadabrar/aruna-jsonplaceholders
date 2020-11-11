package com.achmadabrar.aruna_test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.achmadabrar.aruna_test.data.model.Post
import io.mockk.*
import kotlinx.coroutines.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @Rule
    @JvmField
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    class generatePostObject { fun post(): Post = Post("testes", 23, "title", 54) }
    class Dao { fun insertPosts(listPost: List<Post>) = println("""Inserting "$listPost"""") }
    class Service(private val post: generatePostObject, private val dao: Dao) {
        fun calculate() {
            val post = post.post()
            val newList = mutableListOf<Post>()
            newList.add(post)
            dao.insertPosts(newList)
        }
    }

    val generator = mockk<generatePostObject>()
    val dao = mockk<Dao>()
    val service = Service(generator, dao)

    @Test
    fun insert_Post_To_Dao() {
        val post = Post("bla bla", 3, "tes", 25)
        val newList = mutableListOf<Post>()
        newList.add(post)
        every { generator.post() } returns post
        every { dao.insertPosts(newList) } just Runs

        service.calculate()

        verifyAll {
            generator.post()
            dao.insertPosts(newList)
        }
    }

}