package com.myc.journeydemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myc.journeydemo.data.dao.CommentDao
import com.myc.journeydemo.data.dao.PostDao
import com.myc.journeydemo.data.model.CommentData
import com.myc.journeydemo.data.model.PostData

/**
 * Created by joemiao.
 *
 * Create the room database init some Dao objects
 */
@Database(
    entities = [PostData::class, CommentData::class],
    version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun commentDao(): CommentDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "post.db"
            ).build()
        }
    }
}