package com.example.quranapp.ui.contents

import com.example.quranapp.core.Abstract
import com.example.quranapp.domain.chapters.ErrorType
import com.example.quranapp.domain.chapters.QuranDomainModel
import com.example.quranapp.domain.chapters.QuranUIStateMapper
import com.example.quranapp.domain.contents.ContentDomainModel
import com.example.quranapp.domain.contents.ContentUIStateMapper
import com.example.quranapp.ui.chapters.QuranUiState

sealed class ContentUI : Abstract.Object<Unit, ContentCommunication>() {

    class Success(
        private val contentsList: List<ContentDomainModel>,
        private val contentUIStateMapper: ContentUIStateMapper
        ) : ContentUI() {
        override fun map(mapper: ContentCommunication) {
            val quranUI: List<ContentUiState> = contentsList.map { contentDomainModel ->
                contentDomainModel.map(contentUIStateMapper)
            }
            mapper.map(quranUI)
        }

    }

    class Fail(private val errorType: ErrorType) : ContentUI() {
        override fun map(mapper: ContentCommunication) {
            mapper.map(listOf(ContentUiState.Fail(errorType)))
        }

    }
}