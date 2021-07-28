package com.myc.journeydemo.data.model

/**
 * Created by joemiao.
 *
 * Data class for the comment object
 */
data class CommentData(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)