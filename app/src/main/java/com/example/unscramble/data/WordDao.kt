package com.example.unscramble.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("Select * from WordsData")
    fun getAllwords(): Flow<List<WordEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(wordEntity: WordEntity)
}