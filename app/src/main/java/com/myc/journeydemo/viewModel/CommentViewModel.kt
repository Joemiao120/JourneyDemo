package com.myc.journeydemo.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myc.journeydemo.data.model.CommentData
import com.myc.journeydemo.data.model.PostData
import com.myc.journeydemo.repository.http.RetrofitClient
import kotlinx.coroutines.launch

class CommentViewModel : ViewModel() {

    private val _commentList = MutableLiveData<List<CommentData>>()
    val commentList: LiveData<List<CommentData>> = _commentList

    fun getCommentList(id:Int) = viewModelScope.launch {
        val data = RetrofitClient.service.getComments(id)
        if (!data.isNullOrEmpty()) {
            Log.d("Joe", data.toString())
        }

        _commentList.postValue(data)
    }
}