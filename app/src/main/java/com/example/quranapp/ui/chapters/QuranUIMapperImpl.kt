package com.example.quranapp.ui.chapters

import com.example.quranapp.domain.chapters.ErrorType
import com.example.quranapp.domain.chapters.QuranDomainModel
import com.example.quranapp.domain.chapters.QuranUIStateMapper
import com.example.quranapp.domain.chapters.QuranUiMapper

class QuranUIMapperImpl(
    private val quranUIStateMapper: QuranUIStateMapper
) : QuranUiMapper {

    override fun map(chaptersList: List<QuranDomainModel>): QuranUI {
        return QuranUI.Success(chaptersList, quranUIStateMapper)
    }

    override fun map(errorType: ErrorType): QuranUI {
        return QuranUI.Fail(errorType)
    }
}