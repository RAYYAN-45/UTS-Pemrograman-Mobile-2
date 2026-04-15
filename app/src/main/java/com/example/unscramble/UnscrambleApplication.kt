package com.example.unscramble

import android.app.Application
import kotlin.getValue
import com.example.unscramble.data.WordsRepository
import com.example.unscramble.data.WordDatabase

class UnscrambleApplication: Application() {
    val database by lazy { WordDatabase.getDatabase(this) }
    val repository by lazy { WordsRepository(database.wordDao()) }
}