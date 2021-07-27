package com.example.mvvmwithkotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey


//data class Post(val userId: Int, val id: Int, val title: String, val body: String)

@Entity
data class Post(
    val userId: Int,
    @field:PrimaryKey
    val id: Int,
    val title: String,
    val body: String
)