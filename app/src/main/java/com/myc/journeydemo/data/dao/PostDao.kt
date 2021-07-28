package com.myc.journeydemo.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myc.journeydemo.data.model.PostData

/**
 * Created by joemiao.
 *
 * Dao file for post data
 */
@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<PostData>): List<Long>

    @Query("Select * From post")
    fun getPosts(): LiveData<List<PostData>>

    @Query("Select * From post WHERE title LIKE '%' || :target || '%' ")
    fun queryPost(target: String): List<PostData>
}