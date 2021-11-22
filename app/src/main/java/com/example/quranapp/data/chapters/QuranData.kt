package com.example.quranapp.data.chapters

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.chapters.net.QuranDomainMapper
import com.example.quranapp.domain.chapters.QuranDomain

sealed class QuranData : Abstract.Object<QuranDomain, QuranDomainMapper>() {
    class Success(private val chaptersList: List<QuranDataModel>) : QuranData() {
        override fun map(mapper: QuranDomainMapper): QuranDomain {
            return mapper.map(chaptersList = chaptersList)
        }

    }
    class Fail(private val e: Exception) : QuranData() {
        override fun map(mapper: QuranDomainMapper): QuranDomain {
            return mapper.map(exception = e)
        }
    }
}
