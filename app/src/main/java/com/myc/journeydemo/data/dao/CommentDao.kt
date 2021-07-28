package com.myc.journeydemo.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myc.journeydemo.data.model.CommentData
import com.myc.journeydemo.data.model.PostData

/**
 * Created by joemiao.
 *
 * Dao file for comment data
 */
@Dao
interface CommentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(comments: List<CommentData>): List<Long>

    @Query("Select * From post")
    fun getComments(): LiveData<List<PostData>>

    @Query("Select * From post WHERE title LIKE '%' || :target || '%' ")
    fun queryComment(target: String): List<PostData>
}