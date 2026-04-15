package com.example.unscramble.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.time.Instant

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase(){
    abstract fun wordDao(): WordDao

    companion object{
        @Volatile
        private var Instance : WordDatabase? = null

        fun getDatabase(context: Context): WordDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, WordDatabase::class.java, "WordsData")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}