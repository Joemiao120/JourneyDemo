package com.myc.journeydemo.repository.http

import com.myc.journeydemo.data.model.CommentData
import com.myc.journeydemo.data.model.PostData
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by joemiao.
 *
 * Interface for all the http request
 */
interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostData>

    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: Int): List<CommentData>
}