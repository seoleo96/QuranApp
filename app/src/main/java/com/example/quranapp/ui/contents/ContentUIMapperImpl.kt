package com.example.quranapp.ui.contents

import com.example.quranapp.domain.chapters.ErrorType
import com.example.quranapp.domain.chapters.QuranDomainModel
import com.example.quranapp.domain.chapters.QuranUIStateMapper
import com.example.quranapp.domain.chapters.QuranUiMapper
import com.example.quranapp.domain.contents.ContentDomainModel
import com.example.quranapp.domain.contents.ContentUIStateMapper
import com.example.quranapp.domain.contents.ContentUiMapper

class ContentUIMapperImpl(
    private val contentUIStateMapper: ContentUIStateMapper
) : ContentUiMapper {

    override fun map(chaptersList: List<ContentDomainModel>): ContentUI {
        return ContentUI.Success(chaptersList, contentUIStateMapper)
    }

    override fun map(errorType: ErrorType): ContentUI {
        return ContentUI.Fail(errorType)
    }
}