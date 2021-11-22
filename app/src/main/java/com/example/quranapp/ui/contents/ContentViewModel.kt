package com.example.quranapp.ui.contents

import androidx.lifecycle.*
import com.example.quranapp.domain.contents.ContentDomain
import com.example.quranapp.domain.contents.ContentUiMapper
import com.example.quranapp.domain.contents.InteractorContents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContentViewModel(
    private val interactor: InteractorContents,
    private val contentUiMapper: ContentUiMapper,
    private val contentCommunication: ContentCommunication,
) : ViewModel() {

    fun fetchChapters() {
        contentCommunication.map(listOf(ContentUiState.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            val contentDomain: ContentDomain = interactor.fetchContentsList()
            val contentUI: ContentUI = contentDomain.map(contentUiMapper)
            withContext(Dispatchers.Main) {
                contentUI.map(contentCommunication)
            }
        }
    }

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<List<ContentUiState>>) {
        contentCommunication.observe(lifecycleOwner, observer)
    }
}