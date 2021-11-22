package com.example.quranapp.ui.chapters

import com.example.quranapp.core.Abstract
import com.example.quranapp.domain.chapters.ErrorType
import com.example.quranapp.domain.chapters.QuranDomainModel
import com.example.quranapp.domain.chapters.QuranUIStateMapper

sealed class QuranUI : Abstract.Object<Unit, QuranCommunication>() {

    class Success(
        private val chaptersList: List<QuranDomainModel>,
        private val quranUIStateMapper: QuranUIStateMapper
        ) : QuranUI() {
        override fun map(mapper: QuranCommunication) {
            val quranUI: List<QuranUiState> = chaptersList.map { quranDomainModel ->
                quranDomainModel.map(quranUIStateMapper)
            }
            mapper.map(quranUI)
        }

    }

    class Fail(private val errorType: ErrorType) : QuranUI() {
        override fun map(mapper: QuranCommunication) {
            mapper.map(listOf(QuranUiState.Fail(errorType)))
        }

    }
}