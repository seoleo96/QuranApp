package com.example.quranapp.domain.chapters

import com.example.quranapp.data.chapters.QuranDataModel
import com.example.quranapp.data.chapters.QuranDataModelToDomainMapper
import com.example.quranapp.data.chapters.net.QuranDomainMapper

class QuranDomainMapperImpl(private val quranDataModelToDomainMapper: QuranDataModelToDomainMapper) :
    QuranDomainMapper {
    override fun map(chaptersList: List<QuranDataModel>): QuranDomain {
        return QuranDomain.Success(chaptersList = chaptersList,
            quranMapper = quranDataModelToDomainMapper)
    }

    override fun map(exception: Exception): QuranDomain {
        return QuranDomain.Fail(exception = exception)
    }
}