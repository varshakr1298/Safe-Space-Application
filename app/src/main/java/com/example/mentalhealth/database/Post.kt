package com.example.mentalhealth.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "all_posts_table")
data class Post(

@PrimaryKey(autoGenerate = false)
@ColumnInfo(name = "post_item_title")
    var post_item_title: String = "",

    @ColumnInfo(name = "post_item")
    var post_item: String = ""
)