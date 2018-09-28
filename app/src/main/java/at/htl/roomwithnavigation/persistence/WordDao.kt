package at.htl.roomwithnavigation.persistence

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import at.htl.roomwithnavigation.entities.Word

@Dao
interface WordDao {
    @Insert
    fun insert(word: Word)

    @Update
    fun update(word: Word)

    @Query("SELECT * from word_table ORDER BY id ASC")
    fun getAllLive(): LiveData<List<Word>>

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Delete
    fun delete(word: Word)
}