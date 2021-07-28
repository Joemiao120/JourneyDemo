package com.myc.journeydemo.viewModel

import com.myc.journeydemo.repository.CommentRepository
import com.myc.journeydemo.repository.PostRepository

/**
 * Created by joemiao.
 *
 * Injector utils for maintaining the relation between viewModel and Repository
 */
object InjectorUtils {

    fun providePostsViewModelFactory(): PostsViewModelFactory {
        val repository = PostRepository()
        return PostsViewModelFactory(repository)
    }

    fun provideCommentsViewModelFactory(): CommentViewModelFactory {
        val repository = CommentRepository()
        return CommentViewModelFactory(repository)
    }
}