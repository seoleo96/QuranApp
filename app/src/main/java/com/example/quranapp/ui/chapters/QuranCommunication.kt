package com.example.quranapp.ui.chapters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.quranapp.core.Abstract

interface QuranCommunication : Abstract.Mapper {

    fun map(list: List<QuranUiState>)
    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<List<QuranUiState>>)

    class Base : QuranCommunication {
        private val listLiveData = MutableLiveData<List<QuranUiState>>()
        override fun map(list: List<QuranUiState>) {
            listLiveData.value = list
        }

        override fun observe(
            lifecycleOwner: LifecycleOwner,
            observer: Observer<List<QuranUiState>>,
        ) {
            listLiveData.observe(lifecycleOwner, observer)
        }
    }
}