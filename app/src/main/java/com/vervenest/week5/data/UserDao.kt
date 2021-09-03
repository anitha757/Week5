package com.vervenest.week5.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:uid)")
    fun findById(uid: Int): User

    @Insert
    fun addUser(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query("Delete FROM user WHERE uid IN (:uid)")
    fun deleteUser(uid: Int)
}