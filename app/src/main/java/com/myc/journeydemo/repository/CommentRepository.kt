package com.myc.journeydemo.repository

import com.myc.journeydemo.repository.http.RetrofitClient

/**
 * Created by joemiao.
 *
 * Repository for comment list page
 */
class CommentRepository {
    /**
     * Get comments by post id
     *
     * @param id post id
     */
    suspend fun getComments(id: Int) = RetrofitClient.service.getComments(id)
}