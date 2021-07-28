package com.myc.journeydemo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myc.journeydemo.repository.CommentRepository

/**
 * Factory for creating a [CommentViewModel] with a constructor that takes a
 * [CommentRepository].
 */
class CommentViewModelFactory(
    private val repository: CommentRepository,
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CommentViewModel(repository) as T
    }
}