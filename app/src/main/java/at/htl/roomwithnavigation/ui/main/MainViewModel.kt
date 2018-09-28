package at.htl.roomwithnavigation.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import at.htl.roomwithnavigation.entities.Word
import at.htl.roomwithnavigation.persistence.WordRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: WordRepository = WordRepository(application)
    private var mAllWords: LiveData<List<Word>> = mRepository.getAllLive()

    fun getAllWords(): LiveData<List<Word>> = mAllWords

}
