package com.myc.journeydemo.repository

import com.myc.journeydemo.repository.http.RetrofitClient

/**
 * Created by joemiao.
 *
 * Repository for post list page
 */
class PostRepository {
    /**
     * Get all post list
     */
    suspend fun getPostList() = RetrofitClient.service.getPosts()
}