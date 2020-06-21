package com.example.mentalhealth.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PostDatabaseDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(postItem: Post)

    @Update
    fun update(postItem: Post)

    @Query("DELETE FROM all_posts_table")
    fun clear()


    @Query("SELECT * FROM all_posts_table")
    fun getAllPosts(): List<Post>

}