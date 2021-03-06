package com.myc.journeydemo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myc.journeydemo.data.model.CommentData
import com.myc.journeydemo.data.model.PostData
import com.myc.journeydemo.repository.CommentRepository
import com.myc.journeydemo.repository.http.RetrofitClient
import kotlinx.coroutines.launch

class CommentViewModel(private val repository: CommentRepository) : ViewModel() {

    // Livedata for all comments
    private val _commentList = MutableLiveData<List<CommentData>>()
    val commentList: LiveData<List<CommentData>> = _commentList

    // Livedata for filter comments
    private val _filterList = MutableLiveData<List<CommentData>>()
    val filterList: LiveData<List<CommentData>> = _filterList

    /**
     * Get all comments by post id
     */
    fun getCommentList(id: Int) = viewModelScope.launch {
        val data = repository.getComments(id)
        if (!data.isNullOrEmpty()) {
            _commentList.postValue(data)
        }
    }

    /**
     * Filter comments by filter text
     */
    fun filterComments(filter: String?) {
        if (!filter.isNullOrEmpty()) {
            _filterList.value = _commentList.value?.filter {
                it.name.contains(filter) || it.email.contains(filter) || it.body.contains(filter)
            }
        } else {
            _filterList.value = _commentList.value
        }
    }
}