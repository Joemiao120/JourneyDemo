package com.myc.journeydemo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by joemiao.
 *
 * Data class for the post object
 */

@Entity(tableName = "post")
data class PostData(
    @ColumnInfo(name = "user_id") val userId: Int,
    @PrimaryKey
    @ColumnInfo(name = "post_id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "body") val body: String
)
