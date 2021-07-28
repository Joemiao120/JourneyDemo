package com.myc.journeydemo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myc.journeydemo.repository.PostRepository

/**
 * Factory for creating a [PostViewModel] with a constructor that takes a
 * [PostRepository].
 */
class PostsViewModelFactory(
    private val repository: PostRepository,
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(repository) as T
    }
}