package com.example.quranapp.domain.chapters

import com.example.quranapp.core.Abstract
import com.example.quranapp.ui.chapters.QuranUI

interface QuranUiMapper : Abstract.Mapper {

    fun map(chaptersList: List<QuranDomainModel>): QuranUI
    fun map(errorType: ErrorType): QuranUI
}