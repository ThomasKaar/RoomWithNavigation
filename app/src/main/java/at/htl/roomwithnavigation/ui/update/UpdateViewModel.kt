package at.htl.roomwithnavigation.ui.update

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import at.htl.roomwithnavigation.entities.Word
import at.htl.roomwithnavigation.persistence.WordRepository

class UpdateViewModel(application: Application) : AndroidViewModel(application) {

    private var mRepository = WordRepository(application)

    fun update(word: Word) {
        mRepository.update(word)
    }

    fun delete(word: Word) {
        mRepository.delete(word)
    }
}
