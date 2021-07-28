package com.myc.journeydemo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myc.journeydemo.data.model.PostData
import com.myc.journeydemo.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    private val _postList = MutableLiveData<List<PostData>>()
    val postList: LiveData<List<PostData>> = _postList

    private val _filterList = MutableLiveData<List<PostData>>()
    val filterList: LiveData<List<PostData>> = _filterList

    fun getPostList() = viewModelScope.launch {
        val data = repository.getPostList()
        if (!data.isNullOrEmpty()) {
            _postList.postValue(data)
        }
    }

    fun filterPosts(filter: String?) {
        if (!filter.isNullOrEmpty()) {
            _filterList.value = _postList.value?.filter {
                it.title.contains(filter) || it.body.contains(filter)
            }
        } else {
            _filterList.value = _postList.value
        }
    }
}