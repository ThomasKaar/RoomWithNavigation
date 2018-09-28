package at.htl.roomwithnavigation.ui.create

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel;
import at.htl.roomwithnavigation.entities.Word
import at.htl.roomwithnavigation.persistence.WordRepository

class CreateViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: WordRepository = WordRepository(application)

    fun insert(word: Word) {
        mRepository.insert(word)
    }
}
