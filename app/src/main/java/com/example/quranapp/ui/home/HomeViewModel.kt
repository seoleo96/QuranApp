package com.example.quranapp.ui.home

import androidx.lifecycle.*
import com.example.quranapp.domain.chapters.Interactor
import com.example.quranapp.domain.chapters.QuranDomain
import com.example.quranapp.domain.chapters.QuranUiMapper
import com.example.quranapp.ui.chapters.QuranCommunication
import com.example.quranapp.ui.chapters.QuranUI
import com.example.quranapp.ui.chapters.QuranUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val interactor: Interactor,
    private val quranUiMapper: QuranUiMapper,
    private val quranCommunication: QuranCommunication,
) : ViewModel() {

    fun fetchChapters(){
        quranCommunication.map(listOf(QuranUiState.Progress))
        viewModelScope.launch(Dispatchers.IO){
            val quranDomain: QuranDomain = interactor.fetchChaptersList()
            val quranUI : QuranUI = quranDomain.map(quranUiMapper)
            withContext(Dispatchers.Main){
                quranUI.map(quranCommunication)
            }
        }
    }

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<List<QuranUiState>>){
        quranCommunication.observe(lifecycleOwner, observer)
    }
}