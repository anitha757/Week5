package com.vervenest.week5.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    var userName: String?,
    var email: String?,
    var gender: String?,
    var dob: String?,
    var time: String?,
    var age: String?
    
)