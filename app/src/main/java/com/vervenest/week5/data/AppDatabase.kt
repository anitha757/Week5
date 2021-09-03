package com.vervenest.week5.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            var tempInstnace = INSTANCE
            if(tempInstnace!=null) {
                return tempInstnace
            }
            synchronized(this) {
                var instnace = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "user_database"
                ).allowMainThreadQueries().build()
                INSTANCE =instnace
                return instnace
            }
        }
    }
}