package com.example.quranapp.ui.contents

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.quranapp.core.Abstract

interface ContentCommunication : Abstract.Mapper {

    fun map(list: List<ContentUiState>)
    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<List<ContentUiState>>)

    class Base : ContentCommunication {
        private val listLiveData = MutableLiveData<List<ContentUiState>>()
        override fun map(list: List<ContentUiState>) {
            listLiveData.value = list
        }

        override fun observe(
            lifecycleOwner: LifecycleOwner,
            observer: Observer<List<ContentUiState>>,
        ) {
            listLiveData.observe(lifecycleOwner, observer)
        }
    }
}