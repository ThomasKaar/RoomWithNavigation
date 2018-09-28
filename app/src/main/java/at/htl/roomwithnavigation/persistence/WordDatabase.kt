package at.htl.roomwithnavigation.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import at.htl.roomwithnavigation.entities.Word

@Database(entities = [Word::class], version = 1)
abstract class WordDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    fun getWordDao(): WordDao = wordDao()

    companion object {
        private var INSTANCE: WordDatabase? = null

        fun getInstance(ctx: Context): WordDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(ctx,
                        WordDatabase::class.java, "word_database")
                        .build()

            }
            return INSTANCE as WordDatabase
        }
    }
}