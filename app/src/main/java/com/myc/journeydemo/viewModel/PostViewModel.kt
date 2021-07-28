package com.myc.journeydemo.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myc.journeydemo.data.model.PostData
import com.myc.journeydemo.repository.http.RetrofitClient
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    private val _postList = MutableLiveData<List<PostData>>()
    val postList: LiveData<List<PostData>> = _postList

    fun getPostList() = viewModelScope.launch {
        val data = RetrofitClient.service.getPosts()
        if (!data.isNullOrEmpty()) {
            Log.d("Joe", data.toString())
        }

        _postList.postValue(data)
    }
}