package com.example.unscramble.data

import kotlinx.coroutines.flow.Flow

class WordsRepository (private val wordDao: WordDao){
    val allWordsStream: Flow<List<WordEntity>> = wordDao.getAllwords()

    suspend fun insertWord(word: String){
        wordDao.insertWord(WordEntity(word = word))
    }
}