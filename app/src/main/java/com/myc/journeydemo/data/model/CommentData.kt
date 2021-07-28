package com.myc.journeydemo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by joemiao.
 *
 * Data class for the comment object
 */
@Entity(tableName = "comment")
data class CommentData(
    @ColumnInfo(name = "post_id") val postId: Int,
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "body") val body: String
)