package com.myc.journeydemo.data.model

/**
 * Created by joemiao.
 *
 * Data class for the post object
 */

data class PostData(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
