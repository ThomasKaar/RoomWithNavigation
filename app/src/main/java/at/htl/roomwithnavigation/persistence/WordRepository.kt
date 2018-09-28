package at.htl.roomwithnavigation.persistence

import android.app.Application
import android.arch.lifecycle.LiveData
import at.htl.roomwithnavigation.entities.Word
import kotlin.concurrent.thread

class WordRepository(application: Application) {
    private val wordDatabase: WordDatabase = WordDatabase.getInstance(application)
    private val wordDao: WordDao = wordDatabase.getWordDao()

    fun insert(word: Word) {
        thread {
            wordDao.insert(word)
        }
    }

    fun update(word: Word) {
        thread {
            wordDao.update(word)
        }
    }

    fun delete(word: Word) {
        thread {
            wordDao.delete(word)
        }
    }

    fun getAllLive(): LiveData<List<Word>> = wordDao.getAllLive()
}